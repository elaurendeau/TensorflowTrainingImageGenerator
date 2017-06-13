package application

@org.springframework.boot.autoconfigure.SpringBootApplication
@org.springframework.context.annotation.ComponentScan(basePackages = arrayOf("service.impl", "infrastructure.impl", "repository.impl", "manager.impl", "controller"))
open class ApplicationRest {
    @org.springframework.context.annotation.Bean
    open fun kotlinModule() = com.fasterxml.jackson.module.kotlin.KotlinModule()

    companion object {

        @JvmStatic fun main(args: Array<String>) {
            org.springframework.boot.SpringApplication.run(application.ApplicationRest::class.java, *args)
        }
    }
}