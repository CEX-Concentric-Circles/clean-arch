package concentric_circles.clean_architecture.repository

import concentric_circles.clean_architecture.model.entity.Order
import concentric_circles.clean_architecture.model.entity.Product
import org.springframework.data.repository.CrudRepository
import java.util.*

interface OrderRepository: CrudRepository<Order, UUID> {
    // this might be needed in the future? idk
//    fun findOrdersContainingAProduct(product: Product): Order?
}