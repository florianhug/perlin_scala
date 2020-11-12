package vector

import scala.util.Random

case class Vector2D(x: Double, y: Double) {
  def length: Double = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))

  def toUnit(): Vector2D = {
    val len = length + 0.000000000000001 //Make sure the new vector's length is less than 1
    new Vector2D(x / len, y / len)
  }
}

object Vector2D {
  def apply(x: Double, y: Double): Option[Vector2D] = if (x.abs <= 1 && y.abs <= 1) Some(new Vector2D(x, y)) else None

  def random2D(): Vector2D = new Vector2D(scalar(), scalar())

  private def scalar() = if (Random.nextBoolean()) Random.nextDouble() else -1 * Random.nextDouble()
}
