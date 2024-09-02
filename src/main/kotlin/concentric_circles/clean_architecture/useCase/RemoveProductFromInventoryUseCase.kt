package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.repository.InventoryRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class RemoveProductFromInventoryUseCase (
    var inventoryRepository: InventoryRepository,
    var productExistsUseCase: CheckIfProductExistsUseCase
) {

    fun removeProductFromInventory (productId: UUID) : Boolean {

        val existingProduct = productExistsUseCase.checkIfProductExists(productId)
//            ?: throw Exception("Product '${existingProduct.name}' does not exist.")

        if (existingProduct != null) {
            inventoryRepository.deleteInventoryByProductId(existingProduct.productId)
            return true
        }

        return false
    }

}