package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Product
import concentric_circles.clean_architecture.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CreateProductUseCase (
    var productRepository: ProductRepository
) {

    fun createProduct(product: Product): Product {
        val existingProduct = productRepository.findProductByName(product.name)

        if (existingProduct != null) {
            throw Exception("Product '${product.name}' already exists. If you want to, you can modify the amount of the product in the inventory.")
        }

        val createdProduct = productRepository.save(product)

        return createdProduct
    }

}