package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Inventory
import concentric_circles.clean_architecture.repository.InventoryRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CheckIfProductIsInStockUseCase (
    var inventoryRepository: InventoryRepository
) {

    fun checkIfProductIsInStock(productId: UUID): Inventory? {

        val productInInventory = inventoryRepository.searchByProductId(productId) ?: return null

        if (productInInventory.productQuantity <= 0) {
            return null
        }

        return productInInventory
    }

}