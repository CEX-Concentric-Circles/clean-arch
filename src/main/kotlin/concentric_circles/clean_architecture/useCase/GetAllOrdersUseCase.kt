package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Order
import concentric_circles.clean_architecture.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class GetAllOrdersUseCase (
    val orderRepository: OrderRepository
) {

    fun getAllOrders(): List<Order> {
        return orderRepository.findAll().toList()
    }

}