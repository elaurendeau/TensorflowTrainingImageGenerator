import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = arrayOf("service.impl", "infrastructure.impl", "repository.impl", "manager.impl", "controller"))
open class ApplicationConfiguration {

}