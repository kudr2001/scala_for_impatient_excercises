package objects6

/**
 * Created by andrey on 21.09.15.
 */
object InchesToCentimeters extends UnitConversion {

  val inchesToCentimetersCoef = 2.54

  override def convert(v: Double) : Double = {
    v * inchesToCentimetersCoef
  }

}
