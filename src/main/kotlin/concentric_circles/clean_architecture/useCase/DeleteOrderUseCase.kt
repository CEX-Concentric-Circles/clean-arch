package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.repository.OrderRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class DeleteOrderUseCase (
    val orderRepository: OrderRepository
){

    fun deleteOrder(orderId: UUID) {

        val existingOrder = orderRepository.findById(orderId)
        ?: throw Exception("Order with ID:'$orderId' does not exist.")

        orderRepository.delete(existingOrder.get())
    }

}