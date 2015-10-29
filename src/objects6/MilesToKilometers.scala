package objects6

/**
 * Created by andrey on 21.09.15.
 */
object MilesToKilometers extends UnitConversion {

  val milesToKilometersCoef = 1.609344

  override def convert(v: Double) : Double = {
    v * milesToKilometersCoef
  }

}
