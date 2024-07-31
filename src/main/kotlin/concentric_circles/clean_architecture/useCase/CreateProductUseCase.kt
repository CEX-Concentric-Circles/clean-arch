package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Product
import concentric_circles.clean_architecture.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CreateProductUseCase (
    var addProductToInventoryUseCase: AddProductToInventoryUseCase
) {

    @Autowired
    lateinit var productRepository: ProductRepository

    fun createProduct(product: Product): Product {
        val existingProduct = productRepository.findProductByName(product.name)

        if (existingProduct != null) {
            addProductToInventoryUseCase.addProductToInventory(existingProduct.productId)
            println("Product '${product.name}' already exists. Added this to the inventory.")
            return existingProduct
        }

        val createdProduct = productRepository.save(product)

        return createdProduct
    }

}