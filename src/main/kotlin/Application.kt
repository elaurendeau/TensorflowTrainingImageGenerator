import `interface`.controller.ImageController
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main(args: Array<String>) {

    val applicationContext = AnnotationConfigApplicationContext(ApplicationConfiguration::class.java)

    val imageController: ImageController = applicationContext.getBean("imageController") as ImageController

    imageController.run("https://images2.onionstatic.com/clickhole/3564/7/original/600.jpg", "D:\\tmp\\testdata");

}