package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Product
import concentric_circles.clean_architecture.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class GetProductUseCase {

    lateinit var productRepository: ProductRepository

    fun getProductById(productId: UUID): Optional<Product> {
        return productRepository.findById(productId)
    }

}