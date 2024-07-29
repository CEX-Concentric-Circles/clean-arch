package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Inventory
import concentric_circles.clean_architecture.model.entity.Product
import org.springframework.stereotype.Service

@Service
class DecreaseProductStockFromInventoryUseCase (
    var productInStock: CheckIfProductIsInStockUseCase
) {

    fun decreaseStock (product: Product): Inventory? {

        val existingProduct = productInStock.checkIfProductIsInStock(product.name)
            ?: throw Exception("Product '${product.name}' does not exist. Please create the product first.")

        existingProduct.productQuantity -= 1

        return existingProduct
    }

}