import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = arrayOf("interface.controller", "infrastructure.impl"))
open class AppConfig {

}