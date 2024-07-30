package concentric_circles.clean_architecture.web

import concentric_circles.clean_architecture.model.entity.Product
import concentric_circles.clean_architecture.service.ProductService
import concentric_circles.clean_architecture.useCase.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class ProductController (
//    val productService: ProductService,
    val getProductUseCase: GetProductUseCase,
    val listAllProductsUseCase: ListAllProductsUseCase,
    val createProductUseCase: CreateProductUseCase,
    val updateProductUseCase: UpdateProductUseCase,
    val deleteProductUseCase: DeleteProductUseCase,
    val checkIfProductExistsUseCase: CheckIfProductExistsUseCase,
    val addProductToInventoryUseCase: AddProductToInventoryUseCase

) {

    @GetMapping("/allproducts")
    fun getAllProducts(): ResponseEntity<List<Product>> {
        return ResponseEntity(listAllProductsUseCase.listAllProducts(), org.springframework.http.HttpStatus.OK)
    }

    @PostMapping("/addproduct")
    fun addProduct(@RequestBody product: Product): ResponseEntity<out Any> {
        val createdProduct = createProductUseCase.createProduct(product)
        return ResponseEntity.ok().body(addProductToInventoryUseCase.addProductToInventory(createdProduct))
    }

    @PostMapping("/getproduct")
    fun getProductById(@RequestBody productId: UUID): ResponseEntity<out Any>{
        return ResponseEntity.ok().body(getProductUseCase.getProductById(productId))
    }

    @PostMapping("/updateproduct")
    fun updateProduct(@RequestBody product: Product): ResponseEntity<out Any> {
        return ResponseEntity.ok().body(updateProductUseCase.updateProduct(product))
    }

    @PostMapping("/deleteproduct")
    fun deleteProduct(@RequestBody product: Product): ResponseEntity<out Any> {
        return ResponseEntity.ok().body(deleteProductUseCase.deleteProduct(product))
    }

//    @PostMapping("/productexists")
//    fun checkIfProductExists(@RequestBody productName: String): ResponseEntity<out Any> {
//        return ResponseEntity.ok().body(checkIfProductExistsUseCase.checkIfProductExists(productName))
//    }

}