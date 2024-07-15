package concentric_circles.clean_architecture

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
	fromApplication<CleanArchitectureApplication>().with(TestcontainersConfiguration::class).run(*args)
}
