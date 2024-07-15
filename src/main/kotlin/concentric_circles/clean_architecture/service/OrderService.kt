package concentric_circles.clean_architecture.service

//import concentric_circles.clean_architecture.model.OrderMapper
//import concentric_circles.clean_architecture.model.ProductMapper
//import concentric_circles.clean_architecture.model.dto.OrderDTO
import concentric_circles.clean_architecture.model.entity.Order
import concentric_circles.clean_architecture.repository.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.concurrent.thread

@Service
class OrderService {

    @Autowired
    lateinit var orderRepository: OrderRepository

    @Autowired
    lateinit var inventoryService: InventoryService

    fun processOrder(order: Order): Order {

        // TODO: once the order is received, the products are removed from the inventory and the stock is updated.
        //  The modifier orderSuccess is toggled to true if processing the order is successful.
        //  The order is then saved in the database.

        //create an order entity from the dto
//        val order = orderMapper.toEntity(orderDTO)

        //get a list of products from the order
        val listOfProducts = order.listOfProducts

        //check if the products in the order are in the inventory
        for (product in listOfProducts) {
            if (!inventoryService.checkIfProductIsInInventory(product.productId ?: throw Exception("Product ID is null"))) {
                throw Exception("Product with product ID ${product.productId} and product name ${product.name} not found in inventory")
            }
        }

        //gonna increment and compare this with the number of products in the order
        var counter = 0

        //for each product in the list of products, decrease the stock from the inventory
        for (product in listOfProducts) {
            if(inventoryService.decreaseProductStockFromInventory(product))
                counter++
        }

        if (counter == listOfProducts.size) {
            orderRepository.save(order)
            order.orderSuccess = true
        }

        return order

    }

    fun listAllOrders(): List<Order> {
        return orderRepository.findAll().toList()
    }

    //i have no idea why we will need this in the scope of our project, but might be good to have for future use
    fun deleteOrder(orderID: UUID): Boolean {
        val order = orderRepository.findById(orderID).orElseThrow { Exception("Order not found") }

        orderRepository.delete(order)
        return true
    }

}