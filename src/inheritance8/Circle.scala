package inheritance8

/**
 * Created by andrey on 24.09.15.
 */
class Circle(val radius: Double) extends Figure{

  override def area(): Double = {
    Math.PI * (radius*radius)
  }

  override def centerPoint(): (Double, Double) = {
    (radius, radius)
  }

}
