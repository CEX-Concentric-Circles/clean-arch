package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Customer
import concentric_circles.clean_architecture.repository.CustomerRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CreateCustomerUseCase(
    var customerRepository: CustomerRepository
) {

    fun createCustomer(customer: Customer) : Customer {
        val existingCustomer = customerRepository.findByFirstNameAndLastName(customer.firstName, customer.lastName)

        if (existingCustomer != null) throw Exception("Customer '${customer.firstName} ${customer.lastName}' already exists.")

        val newCustomer = Customer(UUID.randomUUID(), customer.firstName, customer.lastName, customer.email)

        customerRepository.save(newCustomer)

        return newCustomer

    }

}