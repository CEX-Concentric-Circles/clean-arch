package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Product
import concentric_circles.clean_architecture.repository.ProductRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class DeleteProductUseCase (
    val productRepository: ProductRepository,
    val productExistsUseCase: CheckIfProductExistsUseCase,
    val getProductUseCase: GetProductUseCase
) {

    @Transactional
    fun deleteProduct (product: Product): Any {

        val searchedProduct = getProductUseCase.getProductById(product.productId)
            ?: throw Exception("Product with name:'${product.name}' does not exist.")

        // TODO: also delete the inventory related to this product if/once the product is deleted.

//        val existingProduct = productRepository.findById(product.productId)
//            ?: throw Exception("Product with ID:'${product.productId}' does not exist.")

//        if(existingProduct == null) throw Exception("Product with ID:'${product.productId}' does not exist.")
//        else
        return productRepository.delete(searchedProduct)
    }

}