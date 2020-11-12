package image

import java.awt.image.BufferedImage
import java.io.File

import javax.imageio.ImageIO

object ImageWriter {

  def writeImage(image: BufferedImage, filePath: String): Unit = {
    val file = new File(filePath)
    ImageIO.write(image, "png", file)
  }

}
