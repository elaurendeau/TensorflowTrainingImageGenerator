package infrastructure.impl

import domain.FileRequest
import domain.RestRequest
import infrastructure.IFileRequestHandler
import infrastructure.IRestRequestHandler
import org.springframework.stereotype.Service
import util.pmap
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*
import javax.imageio.ImageIO

@Service
class FileRequestHandler : IFileRequestHandler {

    companion object {
        val FILE_EXTENSION = ".txt"
    }

    override fun persist(request: FileRequest, imageLabelPairList: List<Pair<BufferedImage, String>>) {

        //must create directories  before writing
        File(request.path).mkdirs()

        val fileName = UUID.randomUUID().toString()
        val path = Paths.get(request.path + File.separatorChar + fileName + FILE_EXTENSION)

        if(request.saveImages) {
            File(request.path + File.separatorChar + fileName).mkdirs()
        }

        val bufferedWriter = Files.newBufferedWriter(path)
        imageLabelPairList.forEach {
            bufferedWriter.write(it.second)

            val image = it.first

            for (y in 0..(image.height - 1)) {
                for (x in 0..(image.width - 1)) {
                    val color = Color(image.getRGB(x, y))
                    bufferedWriter.write(";[" + color.red + "," + color.green + "," + color.blue + "]")
                }
            }
            bufferedWriter.newLine()

            if (request.saveImages) {
                saveImage(request.path + File.separatorChar + fileName, it)
            }
        }
    }

    private fun saveImage(path: String, imageLabelPairList: Pair<BufferedImage, String>) {
        val byteArrayOutputStream = ByteArrayOutputStream();
        ImageIO.write(imageLabelPairList.first, "png", byteArrayOutputStream);
        FileOutputStream(path + File.separatorChar + imageLabelPairList.second + "--" + UUID.randomUUID().toString() + ".png").write(byteArrayOutputStream.toByteArray());
    }
}


