package vector

class VectorGrid(private val grid: Array[Array[Vector2D]]) {
  def width: Int = grid.length

  def height: Int = grid(0).length

  def apply(x: Int, y: Int): Option[Vector2D] = if (x >= 0 && x < width && y >= 0 && y < height) Some(grid(x)(y)) else None
}


object VectorGrid {
  def apply(array: Array[Array[Vector2D]]): VectorGrid = new VectorGrid(array)

  def createRandomGrid(width: Int, height: Int): VectorGrid = {
    val array: Array[Array[Vector2D]] = Array.ofDim[Vector2D](width, height)

    for (x <- 0 until width;
         y <- 0 until height) {
      array(x)(y) = Vector2D.random2D()
    }
    VectorGrid(array)
  }
}
