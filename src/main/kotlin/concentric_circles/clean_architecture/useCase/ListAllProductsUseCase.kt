package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Product
import concentric_circles.clean_architecture.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ListAllProductsUseCase {

    lateinit var productRepository: ProductRepository

    fun listAllProducts(): List<Product> {

        val allProducts = productRepository.listAllProducts()

        return allProducts
    }
}