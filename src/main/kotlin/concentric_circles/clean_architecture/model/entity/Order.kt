package concentric_circles.clean_architecture.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.util.*

@Entity
class Order(
    @Id
    var orderId: UUID,
    @OneToMany
    val listOfProducts: List<Product> = mutableListOf(),
    var orderSuccess: Boolean = false
){
    override fun toString(): String {
        return "Order(id=$orderId, List Of products=$listOfProducts)"
    }
}