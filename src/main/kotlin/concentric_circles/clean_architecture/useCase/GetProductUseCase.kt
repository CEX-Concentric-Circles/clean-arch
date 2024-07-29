package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Product
import concentric_circles.clean_architecture.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class GetProductUseCase (
    val productRepository: ProductRepository
) {

    fun getProductById(productId: UUID): Product? {
        return productRepository.findProductByProductId(productId)
    }

}