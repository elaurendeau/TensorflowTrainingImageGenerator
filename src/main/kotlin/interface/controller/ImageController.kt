package `interface`.controller

import infrastructure.IImageHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
object ImageController {

    @Autowired
    lateinit var imageHandler: IImageHandler


    fun run(url: String) {
        println("test" + imageHandler)
    }


}