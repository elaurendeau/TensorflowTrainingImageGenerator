import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = arrayOf("service.impl", "infrastructure.impl", "repository.impl", "manager.impl", "controller"))
open class ApplicationRest {
    @Bean
    open fun kotlinModule() = KotlinModule()

    companion object {

        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(ApplicationRest::class.java, *args)
        }
    }
}