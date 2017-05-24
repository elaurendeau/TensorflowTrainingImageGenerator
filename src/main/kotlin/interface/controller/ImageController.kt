package `interface`.controller

import infrastructure.IImageHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller

@Component
open class ImageController @Autowired constructor(val imageHandler: IImageHandler) {

    fun run(url: String) {
        println("test" + imageHandler)
    }


}