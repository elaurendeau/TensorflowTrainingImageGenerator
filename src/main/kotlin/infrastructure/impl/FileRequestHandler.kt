package infrastructure.impl

import domain.FileRequest
import infrastructure.IFileRequestHandler
import org.springframework.stereotype.Service
import util.pmap
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import java.io.FileOutputStream
import javax.imageio.ImageIO

@Service
class FileRequestHandler : IFileRequestHandler {
    override fun persist(request: FileRequest, imageLabelPairList: List<Pair<BufferedImage, String>>) {
        val byteArrayOutputStream = ByteArrayOutputStream();
        imageLabelPairList.pmap {
            ImageIO.write(it.first, "png", byteArrayOutputStream);
            FileOutputStream(request.path + "\\" + it.second + ".png").write(byteArrayOutputStream.toByteArray());
        }
    }

}
