package concentric_circles.clean_architecture

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
open class CleanArchitectureApplication

fun main(args: Array<String>) {
	runApplication<CleanArchitectureApplication>(*args)
}
