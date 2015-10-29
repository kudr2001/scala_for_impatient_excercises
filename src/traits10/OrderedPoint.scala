package traits10

import java.awt.Point

/**
 * Created by andrey on 05.10.15.
 */
class OrderedPoint(x: Int, y: Int) extends Point(x: Int, y: Int) with Ordered[Point]{

  /** Result of comparing `this` with operand `that`.
    *
    * Implement this method to determine how instances of A will be sorted.
    *
    * Returns `x` where:
    *
    *   - `x < 0` when `this < that`
    *
    *   - `x == 0` when `this == that`
    *
    *   - `x > 0` when  `this > that`
    *
    */
  override def compare(that: Point): Int = {
    if (this.x == that.x && this.y == that.y) {
      0
    } else if (this.x < that.x || this.x == that.x && this.y < that.y) {
      -1
    } else {
      1
    }
  }

  def this() = {
    this(0, 0)
  }



}
