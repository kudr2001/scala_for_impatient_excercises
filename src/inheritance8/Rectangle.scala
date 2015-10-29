package inheritance8

/**
 * Created by andrey on 24.09.15.
 */
class Rectangle(val width: Double, val length: Double) extends Figure{

  def area(): Double = {
    length * width
  }

  def centerPoint(): (Double, Double) = {
    (length/2, width/2)
  }
}
