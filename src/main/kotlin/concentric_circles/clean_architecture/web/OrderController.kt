package concentric_circles.clean_architecture.web

import concentric_circles.clean_architecture.model.entity.Order
import concentric_circles.clean_architecture.useCase.CreateOrderUseCase
import concentric_circles.clean_architecture.useCase.DeleteOrderUseCase
import concentric_circles.clean_architecture.useCase.GetAllOrdersUseCase
import concentric_circles.clean_architecture.useCase.ProcessOrderUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class OrderController (
    val createOrderUseCase: CreateOrderUseCase,
    val processOrderUseCase: ProcessOrderUseCase,
    val deleteOrderUseCase: DeleteOrderUseCase,
    val getAllOrdersUseCase: GetAllOrdersUseCase
) {

    @PostMapping("/createorder")
    fun createOrder(@RequestBody productId: UUID): ResponseEntity<out Any> {
        return ResponseEntity.ok().body(createOrderUseCase.createOrder(productId))
    }

    @PostMapping("/processorder")
    fun processOrder(@RequestBody orderId: UUID): ResponseEntity<out Any> {
        return ResponseEntity.ok().body(processOrderUseCase.processOrder(orderId))
    }

    @PostMapping("/deleteorder")
    fun deleteOrder(@RequestBody orderId: UUID): ResponseEntity<out Any> {
        return ResponseEntity.ok().body(deleteOrderUseCase.deleteOrder(orderId))
    }

    @GetMapping("/allorders")
    fun getAllOrders(): ResponseEntity<out Any> {
        return ResponseEntity.ok().body(getAllOrdersUseCase.getAllOrders())
    }

}