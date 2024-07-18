package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Inventory
import concentric_circles.clean_architecture.repository.InventoryRepository
import org.springframework.stereotype.Service

@Service
class CheckIfProductIsInStockUseCase {

    lateinit var inventoryRepository: InventoryRepository

    lateinit var productExistsUseCase: CheckIfProductExistsUseCase

    fun checkIfProductIsInStock(productName: String): Inventory? {

        val existingProduct = productExistsUseCase.checkIfProductExists(productName)
            ?: throw Exception("Product '${productName}' does not exist. Please create the product first.")

        val productInInventory = inventoryRepository.searchByProductId(existingProduct.productId)

        return productInInventory
    }
}