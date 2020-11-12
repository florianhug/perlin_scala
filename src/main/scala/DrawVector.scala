import java.awt.image.BufferedImage

import image.Canvas
import vector.Vector2D

object DrawVector {

  def drawVector(vector: Vector2D, width: Int, height: Int): BufferedImage = {
    val canvas = new Canvas(width, height)
    val canvasCenter = Tuple2[Int, Int](width / 2, height / 2)
    for (x <- 0 until width;
         y <- 0 until height) {
      val factorX = (canvasCenter._1 - x).toDouble / width
      val factorY = (canvasCenter._2 - y).toDouble / height
      val value = vector.x * factorX + vector.y * factorY
      canvas.setPixel(x, y, value)
    }
    canvas.getImage()
  }

}
