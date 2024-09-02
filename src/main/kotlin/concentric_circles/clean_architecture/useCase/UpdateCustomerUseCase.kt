package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Customer
import concentric_circles.clean_architecture.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class UpdateCustomerUseCase (
    val customerRepository: CustomerRepository
) {

    fun updateCustomer(customer: Customer) {
        val existingCustomer = customerRepository.findById(customer.customerId)

        if (existingCustomer.isEmpty) throw Exception("Customer '${customer.firstName} ${customer.lastName}' does not exist. Please create the customer first.")
        else {
            existingCustomer.get().firstName = customer.firstName
            existingCustomer.get().lastName = customer.lastName
            existingCustomer.get().email = customer.email
            customerRepository.save(existingCustomer.get())
        }
    }

}