package vector

object MathUtils {

  implicit val precision: Double = 0.01

  implicit class ExtendedDouble(val value: Double) extends AnyVal {
    def ~=(other: Double): Boolean = (value - other).abs < precision
  }

}
