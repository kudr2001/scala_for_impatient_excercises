package objects6

/**
 * Created by andrey on 21.09.15.
 */
object CardSuits extends Enumeration{

  val RedHearts = Value(0, "\u2661")
  val RedDiamonds = Value(1, "\u2662")
  val RedClubs = Value(2, "\u2667")
  val RedSpades = Value(3, "\u2664")

  val BlackHearts = Value(10, "\u2665")
  val BlackDiamonds = Value(11, "\u2666")
  val BlackClubs = Value(12, "\u2663")
  val BlackSpades = Value(13, "\u2660")

  def isRed(cardSuits: CardSuits.Value ): Boolean = {
    cardSuits.id < 10
  }

}
