import DrawCorners.{getVectorValue, lerp}
import image.Canvas
import vector.{Vector2D, VectorGrid}

class DrawCorners(private val vectorGrid: VectorGrid, private val width: Int, private val height: Int) {
  private val canvas = new Canvas(width, height)

  def drawGrid(): Canvas = {
    for (x <- 0 until width;
         y <- 0 until height) {
      getValueAt(x, y).foreach(canvas.setPixel(x, y, _))
    }
    canvas
  }

  private def getValueAt(x: Int, y: Int) = {
    val factorX: Double = (width - x).toDouble / width
    val factorY: Double = (height - y).toDouble / height

    def vectorValue: Vector2D => Double = getVectorValue(factorX, factorY)

    for {vec00 <- vectorGrid(0, 0)
         vec01 <- vectorGrid(0, 1)
         vec10 <- vectorGrid(1, 0)
         vec11 <- vectorGrid(1, 1)
         val00 = vectorValue(vec00)
         val01 = vectorValue(vec01)
         val10 = vectorValue(vec10)
         val11 = vectorValue(vec11)
         val0 = lerp(val00, val01, factorX)
         val1 = lerp(val10, val11, factorX)
         value = lerp(val0, val1, factorY)
         } yield value
  }
}

object DrawCorners {
  private def getVectorValue(factorX: Double, factorY: Double)(vector: Vector2D) = {
    vector.x * factorX + vector.y * factorY
  }

  private def lerp(val0: Double, val1: Double, factor: Double) = {
    if (factor >= 1.0)
      val1
    else if (factor <= 0)
      val0
    else
      (1.0 - factor) * val0 + factor * val1
  }
}
