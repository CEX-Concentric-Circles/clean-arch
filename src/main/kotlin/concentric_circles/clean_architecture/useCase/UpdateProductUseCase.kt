package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Product
import concentric_circles.clean_architecture.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UpdateProductUseCase {

    lateinit var productRepository: ProductRepository

    fun updateProduct(product: Product): Product? {

        val searchedProduct = productRepository.findProductByProductId(product.productId)

        if (searchedProduct == null) throw Exception("Product '${product.name}' does not exist. Please create the product first.")
        else {
            searchedProduct.name = product.name
            searchedProduct.price = product.price
        }

        return productRepository.save(searchedProduct)
    }
}