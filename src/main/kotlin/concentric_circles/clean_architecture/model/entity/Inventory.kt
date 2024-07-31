package concentric_circles.clean_architecture.model.entity

import jakarta.persistence.*
import lombok.Data
import java.util.*

@Entity
@Data
@Table(name = "inventory")
class Inventory(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    val inventoryId: UUID = UUID.randomUUID(),

    @Column
    val productId: UUID? = null,

    @Column
    var productQuantity: Int
)