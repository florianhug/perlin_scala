package image

import java.awt.Color
import java.awt.image.BufferedImage

class Canvas(val width: Int, val height: Int) {
  private val image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY)

  /**
   *
   * @param x     coordinate
   * @param y     coordinate
   * @param value -1 to 1
   */
  def setPixel(x: Int, y: Int, value: Double): Unit = {
    val colorVal = ((255 * value + 255) / 2).toInt
    val color = new Color(colorVal, colorVal, colorVal)
    image.setRGB(x, y, color.getRGB)
  }

  def getImage(): BufferedImage = image

}
