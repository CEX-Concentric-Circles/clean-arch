package concentric_circles.clean_architecture.model.entity

import jakarta.persistence.*
import lombok.Data
import java.util.*

@Entity
@Data
@Table(name = "order_table")
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    var orderId: UUID = UUID.randomUUID(),

//    @OneToMany
//    @Column
//    val listOfProducts: List<Product> = mutableListOf(),

    @Column
    var productId: UUID? = null,

    @Column
    var orderSuccess: Boolean = false
){
    override fun toString(): String {
        return "Order(id=$orderId, productID='$productId', orderSuccess=$orderSuccess)"
    }
}