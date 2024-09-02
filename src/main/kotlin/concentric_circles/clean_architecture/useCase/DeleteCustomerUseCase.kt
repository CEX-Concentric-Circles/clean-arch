package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.repository.CustomerRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class DeleteCustomerUseCase (
    val customerRepository: CustomerRepository
) {

    fun deleteCustomer(customerId: UUID) {

        val existingCustomer = customerRepository.findById(customerId)

        if (existingCustomer.isEmpty) throw Exception("Customer with ID '${customerId}' does not exist.")

        customerRepository.deleteById(customerId)
    }

}