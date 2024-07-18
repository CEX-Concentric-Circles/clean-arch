package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.repository.InventoryRepository
import org.springframework.stereotype.Service

@Service
class RemoveProductFromInventoryUseCase {

    lateinit var inventoryRepository: InventoryRepository

    lateinit var productExistsUseCase: CheckIfProductExistsUseCase

    fun removeProductFromInventory (productName: String) : Boolean {

        val existingProduct = productExistsUseCase.checkIfProductExists(productName)
            ?: throw Exception("Product '${productName}' does not exist.")

        return inventoryRepository.deleteInventoryByProductId(existingProduct.productId)
    }
}