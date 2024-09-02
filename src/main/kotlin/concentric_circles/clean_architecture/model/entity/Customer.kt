package concentric_circles.clean_architecture.model.entity

import jakarta.persistence.*
import lombok.Data
import java.util.*

@Entity
@Data
@Table(name = "customer")
class Customer (

    @Id
    val customerId: UUID = UUID.randomUUID(),

    @Column
    var firstName: String,

    @Column
    var lastName: String,

    @Column
    var email: String
){
    override fun toString(): String {
        return "Customer(id=$customerId, firstName='$firstName', lastName='$lastName', email='$email')"
    }
}