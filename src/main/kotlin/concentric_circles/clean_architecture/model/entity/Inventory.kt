package concentric_circles.clean_architecture.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.*

@Entity
class Inventory(
    @Id
    val inventoryId: UUID,
    val productId: UUID? = null,
    var productQuantity: Int
)