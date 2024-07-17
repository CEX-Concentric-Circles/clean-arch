package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Product
import concentric_circles.clean_architecture.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class CheckIfProductExistsUseCase {

    lateinit var productRepository: ProductRepository

    fun checkIfProductExists(productName: String): Product? {

        val searchedProduct = productRepository.findProductByName(productName)

        return searchedProduct
    }
}