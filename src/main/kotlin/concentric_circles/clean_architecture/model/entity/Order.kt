package concentric_circles.clean_architecture.model.entity

import jakarta.persistence.*
import lombok.Data
import java.util.*

@Entity
@Data
@Table(name = "`order`")
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    var orderId: UUID,

    @OneToMany
    @Column
    val listOfProducts: List<Product> = mutableListOf(),

    @Column
    var orderSuccess: Boolean = false
){
    override fun toString(): String {
        return "Order(id=$orderId, List Of products=$listOfProducts)"
    }
}