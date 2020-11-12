package vector

import org.scalatest.FunSuite

class VectorGridTest extends FunSuite {

  test("The grid should be of the correct size") {
    val grid = VectorGrid.createRandomGrid(2, 3)
    assert(grid.width == 2)
    assert(grid.height == 3)
  }

}
