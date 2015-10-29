package objects6

/**
 * Created by andrey on 21.09.15.
 */
object Conversions {

  val milesToKilometersCoef = 1.609344
  val gallonsToLitersCoef = 3.785412
  val inchesToCentimetersCoef = 2.54

  def inchesToCentimeters(v: Double) : Double = {
    v * inchesToCentimetersCoef
  }

  def gallonsToLiters(v: Double) : Double = {
    v * gallonsToLitersCoef
  }

  def milesToKilometers(v: Double) : Double = {
    v * milesToKilometersCoef
  }

}
