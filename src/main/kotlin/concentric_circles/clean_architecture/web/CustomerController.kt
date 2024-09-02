package concentric_circles.clean_architecture.web

import concentric_circles.clean_architecture.model.entity.Customer
import concentric_circles.clean_architecture.useCase.CreateCustomerUseCase
import concentric_circles.clean_architecture.useCase.DeleteCustomerUseCase
import concentric_circles.clean_architecture.useCase.GetAllCustomersUseCase
import concentric_circles.clean_architecture.useCase.UpdateCustomerUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class CustomerController (
    val createCustomerUseCase: CreateCustomerUseCase,
    val updateCustomerUseCase: UpdateCustomerUseCase,
    val deleteCustomerUseCase: DeleteCustomerUseCase,
    val getAllCustomersUseCase: GetAllCustomersUseCase
) {

    @PostMapping("/createcustomer")
    fun createCustomer(@RequestBody customer: Customer): ResponseEntity<Any> {
        val newCustomer = createCustomerUseCase.createCustomer(customer)
        return ResponseEntity.ok(newCustomer)
    }

    @PostMapping("/updatecustomer")
    fun updateCustomer(@RequestBody customer: Customer): ResponseEntity<Any> {
        val updatedCustomer = updateCustomerUseCase.updateCustomer(customer)
        return ResponseEntity.ok(updatedCustomer)
    }

    @PostMapping("/deletecustomer")
    fun deleteCustomer(@RequestBody customerId: UUID): ResponseEntity<Any> {
        deleteCustomerUseCase.deleteCustomer(customerId)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/allcustomers")
    fun getAllCustomers(): ResponseEntity<Any> {
        return ResponseEntity.ok(getAllCustomersUseCase.getAllCustomers())
    }
}