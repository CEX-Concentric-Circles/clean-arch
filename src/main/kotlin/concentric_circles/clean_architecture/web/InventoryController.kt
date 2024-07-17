package concentric_circles.clean_architecture.web

import concentric_circles.clean_architecture.model.entity.Product
import concentric_circles.clean_architecture.service.InventoryService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class InventoryController (val inventoryService: InventoryService) {

    @GetMapping("/inventory")
    fun getInventory(): String {
        return inventoryService.listAllProductsInInventory().toString()
    }

    @Operation(summary = "Add a product to the inventory.")
    @PostMapping("/addtoinventory")
    fun addProductToInventory(@RequestBody product : Product, amount: Int = 1): ResponseEntity<out Any> {
        val newProduct = inventoryService.addProductToInventory(product, amount)
        return ResponseEntity.ok(newProduct)
    }

}