package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Inventory
import concentric_circles.clean_architecture.model.entity.Product
import concentric_circles.clean_architecture.repository.InventoryRepository
import concentric_circles.clean_architecture.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class AddProductToInventoryUseCase (
    var productRepository: ProductRepository,
    var inventoryRepository: InventoryRepository
) {

    fun addProductToInventory(productId: UUID, amount: Int = 1): Inventory?{

        val searchedProduct = productRepository.findProductByProductId(productId)
            ?: throw Exception("Product with the ID:'${productId}' does not exist. Please create the product first.")

        val inventoryItem = inventoryRepository.findInventoryByProductId(searchedProduct.productId)

        if (inventoryItem != null){
            inventoryItem.productQuantity += amount
        } else {
            return inventoryRepository.save(Inventory(inventoryId = UUID.randomUUID(), productId = searchedProduct.productId, productQuantity = amount))
        }

        return inventoryItem
    }
}