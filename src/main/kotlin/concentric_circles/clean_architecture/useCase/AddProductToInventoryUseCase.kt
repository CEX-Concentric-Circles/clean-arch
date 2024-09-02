package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Inventory
import concentric_circles.clean_architecture.repository.InventoryRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class AddProductToInventoryUseCase (
    var inventoryRepository: InventoryRepository
) {

    fun addProductToInventory(productId: UUID, amount: Int = 1): Inventory?{

        val inventoryItem = inventoryRepository.findInventoryByProductId(productId)

        if (inventoryItem != null){
            inventoryItem.productQuantity += amount
        } else {
            return inventoryRepository.save(Inventory(inventoryId = UUID.randomUUID(), productId = productId, productQuantity = amount))
        }

        return inventoryRepository.save(inventoryItem)
    }
}