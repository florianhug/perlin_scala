import image.ImageWriter
import vector.{Vector2D, VectorGrid}

object Main {

  val width = 100
  val height = 100

  def main(args: Array[String]): Unit = {
    val vectorGrid = VectorGrid.createRandomGrid(10, 10)
    print(vectorGrid)
    val canvas = new DrawCorners(vectorGrid, width, height)
      .drawGrid()
    ImageWriter.writeImage(canvas.getImage(), "/home/fhug/Pictures/perlin_scala.png")
    //    Some(Vector2D.random2D())
    //      .map(DrawVector.drawVector(_, width, height))
    //      .foreach(ImageWriter.writeImage(_, "/home/fhug/Pictures/perlin_scala.png"))
  }
}
