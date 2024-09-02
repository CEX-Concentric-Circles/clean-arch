package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Inventory
import concentric_circles.clean_architecture.model.entity.Order
import concentric_circles.clean_architecture.repository.OrderRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ProcessOrderUseCase (
    val orderRepository: OrderRepository,
    val getProductUseCase: GetProductUseCase,
    val decreaseProductStockFromInventoryUseCase: DecreaseProductStockFromInventoryUseCase
) {

    fun processOrder(orderId: UUID): Order {

        val searchedOrder = orderRepository.findById(orderId)
        if (searchedOrder.isEmpty) {
            throw Exception("Order with the ID:'${orderId}' does not exist.")
        }

        val order = searchedOrder.get()

        val productInTheOrder = order.productId.let { getProductUseCase.getProductById(it) }
        ?: throw Exception("Product with the ID:'${order.productId}' does not exist.")

        val newInventory = decreaseProductStockFromInventoryUseCase.decreaseStock(productInTheOrder)

        if (newInventory != null)
            order.orderSuccess = true
        else
            order.orderSuccess = false

        return orderRepository.save(order)
    }
}