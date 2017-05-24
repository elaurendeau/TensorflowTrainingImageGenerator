import `interface`.controller.ImageController
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main(args: Array<String>) {
//    val url: String = "https://images2.onionstatic.com/clickhole/3564/7/original/600.jpg";
//    val img = ImageIO.read(URL(url))
//    val gfx = img.createGraphics()
//    gfx.setFont(Font("TimesRoman", Font.PLAIN, 50))
//    gfx.setColor(Color.BLUE)
//    gfx.drawString("test", 80, 80)
//
//    val byteArrayOutputStream = ByteArrayOutputStream();
//    ImageIO.write(img, "png", byteArrayOutputStream);
//    FileOutputStream("test.png").write(byteArrayOutputStream.toByteArray());o

    val applicationContext = AnnotationConfigApplicationContext(ApplicationConfiguration::class.java)

    val imageController: ImageController = applicationContext.getBean("imageController") as ImageController

    imageController.run("https://images2.onionstatic.com/clickhole/3564/7/original/600.jpg");

}