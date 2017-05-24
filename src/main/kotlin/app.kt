import `interface`.controller.ImageController
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import java.awt.Color
import java.awt.Font
import java.awt.font.FontRenderContext
import java.awt.font.TextLayout
import java.io.ByteArrayOutputStream
import java.io.FileOutputStream
import java.net.URL
import javax.imageio.ImageIO

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

    val applicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)

    val imageController: ImageController = applicationContext.getBean("imageController") as ImageController

    imageController.run("https://images2.onionstatic.com/clickhole/3564/7/original/600.jpg");

}