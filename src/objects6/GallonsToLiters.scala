package objects6

/**
 * Created by andrey on 21.09.15.
 */
object GallonsToLiters extends UnitConversion {
  val gallonsToLitersCoef = 3.785412

  override def convert(v: Double) : Double = {
    v * gallonsToLitersCoef
  }

}
