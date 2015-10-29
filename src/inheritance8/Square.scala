package inheritance8

/**
 * Created by andrey on 24.09.15.
 */
class Square(x: Int, y: Int, width: Int) extends java.awt.Rectangle(x, y, width, width) {

  def this() {
    this(0, 0, 0)
  }

  def this(width: Int) {
    this(0, 0, width)
  }
}
