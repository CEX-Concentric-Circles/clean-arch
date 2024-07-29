package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class DeleteProductUseCase (
    val productRepository: ProductRepository,
    val productExistsUseCase: CheckIfProductExistsUseCase
) {

    fun deleteProduct (productName: String): Boolean {

        val existingProduct = productExistsUseCase.checkIfProductExists(productName)
            ?: throw Exception("Product '${productName}' does not exist.")

        return productRepository.deleteProductByProductId(existingProduct.productId)
    }

}