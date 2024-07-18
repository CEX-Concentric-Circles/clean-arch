package concentric_circles.clean_architecture.repository

import concentric_circles.clean_architecture.model.entity.Inventory
import concentric_circles.clean_architecture.model.entity.Product
import org.springframework.data.repository.CrudRepository
import java.util.*

// do we even need this?
interface InventoryRepository: CrudRepository<Inventory, UUID> {
    fun findInventoryByProductId(productId: UUID): Inventory?
    fun searchByProductId(productId: UUID): Inventory?
    fun deleteInventoryByProductId(productId: UUID): Boolean
    // what else to add here? :think:
}