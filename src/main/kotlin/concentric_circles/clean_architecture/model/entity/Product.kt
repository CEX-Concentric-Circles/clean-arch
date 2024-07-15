package concentric_circles.clean_architecture.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.*

@Entity
class Product (
    @Id
    val productId: UUID,
    var name: String,
    var price: Double,
//    val description: String
) {
     override fun toString(): String {
        return "Product(id=$productId, name='$name', price=$price)"
    }
}