package concentric_circles.clean_architecture.repository

import concentric_circles.clean_architecture.model.entity.Product
import org.springframework.data.repository.CrudRepository
import java.util.*

interface ProductRepository: CrudRepository<Product, UUID> {
    fun findProductByName(name: String): Product?
    fun findProductByProductId(productId: UUID): Product?
    fun listAllProducts(): List<Product>
}