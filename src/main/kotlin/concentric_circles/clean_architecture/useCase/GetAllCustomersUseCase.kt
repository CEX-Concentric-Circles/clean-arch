package concentric_circles.clean_architecture.useCase

import concentric_circles.clean_architecture.model.entity.Customer
import concentric_circles.clean_architecture.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class GetAllCustomersUseCase (
    val customerRepository: CustomerRepository
) {

        fun getAllCustomers() : List<Customer> = customerRepository.findAll().toList()

}