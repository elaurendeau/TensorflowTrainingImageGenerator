import java.io.ByteArrayOutputStream
import java.io.FileOutputStream
import java.net.URL
import javax.imageio.ImageIO

fun main(args: Array<String>) {
    val url: String = "https://images2.onionstatic.com/clickhole/3564/7/original/600.jpg";
    val img = ImageIO.read(URL(url))
    val gfx = img.createGraphics();
    gfx.drawString("test", 10, 10);
    val byteArrayOutputStream = ByteArrayOutputStream();
    ImageIO.write(img, "png", byteArrayOutputStream);
    FileOutputStream("test.png").write(byteArrayOutputStream.toByteArray());

}