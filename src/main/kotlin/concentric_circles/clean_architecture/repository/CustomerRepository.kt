package concentric_circles.clean_architecture.repository

import concentric_circles.clean_architecture.model.entity.Customer
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface CustomerRepository: CrudRepository<Customer, UUID> {
    fun findByFirstNameAndLastName(firstName: String, lastName: String): Customer?
}