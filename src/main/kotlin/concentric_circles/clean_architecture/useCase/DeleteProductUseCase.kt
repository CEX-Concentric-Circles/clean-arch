package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Product
import concentric_circles.clean_architecture.repository.ProductRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class DeleteProductUseCase (
    val productRepository: ProductRepository,
    val productExistsUseCase: CheckIfProductExistsUseCase
) {

    @Transactional
    fun deleteProduct (product: Product): Any {

        val existingProduct = productExistsUseCase.checkIfProductExists(product.name)
            ?: throw Exception("Product with name:'${product.name}' does not exist.")

//        val existingProduct = productRepository.findById(product.productId)
//            ?: throw Exception("Product with ID:'${product.productId}' does not exist.")

//        if(existingProduct == null) throw Exception("Product with ID:'${product.productId}' does not exist.")
//        else
        return productRepository.delete(existingProduct)
    }

}