package concentric_circles.clean_architecture.web

import concentric_circles.clean_architecture.model.entity.Product
import concentric_circles.clean_architecture.service.ProductService
import concentric_circles.clean_architecture.useCase.GetProductUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class ProductController (
    val productService: ProductService,
    val getProductUseCase: GetProductUseCase
) {

    @GetMapping("/allproducts")
    fun getAllProducts(): ResponseEntity<List<Product>> {
        return ResponseEntity(productService.listAllProducts(), org.springframework.http.HttpStatus.OK)
    }

    @PostMapping("/addproduct")
    fun addProduct(@RequestBody product: Product):ResponseEntity<out Any> {
        return ResponseEntity.ok().body(productService.createProduct(product))
    }

    @GetMapping("/getproduct")
    fun getProductById(@RequestBody productId: UUID): ResponseEntity<out Any>{
        return ResponseEntity.ok().body(getProductUseCase.getProductById(productId))
    }

}