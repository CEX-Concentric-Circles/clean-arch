package concentric_circles.clean_architecture.model.entity

import jakarta.persistence.*
import lombok.Data
import java.util.*

@Entity
@Data
@Table(name = "`product`")
class Product (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    val productId: UUID = UUID.randomUUID(),

    @Column
    var name: String,

    @Column
    var price: Double,
//    val description: String
) {
     override fun toString(): String {
        return "Product(id=$productId, name='$name', price=$price)"
    }
}