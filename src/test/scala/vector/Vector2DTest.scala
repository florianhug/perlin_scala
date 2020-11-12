package vector

import org.scalatest.FunSuite
import vector.MathUtils.ExtendedDouble

import scala.util.Random

class Vector2DTest extends FunSuite {

  test("Should calculate the length") {
    assert(new Vector2D(12.3, 33.1).length ~= 35.31147122395214)
    assert(new Vector2D(-0.21, 10).length ~= 9.99779475684513)
  }

  test("It should be convertible to its unit vector") {
    for (i <- 0 until 100) {
      assert(new Vector2D(Random.nextDouble(), Random.nextDouble()).toUnit().length <= 1.0)
    }
  }

}
