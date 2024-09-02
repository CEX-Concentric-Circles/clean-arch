package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Product
import concentric_circles.clean_architecture.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CheckIfProductExistsUseCase (
    var productRepository: ProductRepository
) {

    fun checkIfProductExists(productId: UUID): Product? {

        val searchedProduct = productRepository.findProductByProductId(productId)

        return searchedProduct
    }

}