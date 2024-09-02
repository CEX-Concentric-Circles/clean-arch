package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Order
import concentric_circles.clean_architecture.repository.OrderRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CreateOrderUseCase (
    val orderRepository: OrderRepository
){

    fun createOrder(order: Order): Order {

        return orderRepository.save(Order(orderId = UUID.randomUUID(), productId = order.productId, customerId = order.customerId))

    }

}