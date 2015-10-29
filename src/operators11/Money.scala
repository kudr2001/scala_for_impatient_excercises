package operators11

/**
 * Created by andrey on 08.10.15.
 */
class Money(val dollars: Int, val cents: Int) {

  override def toString = dollars + "." + cents

  def +(other: Money): Money = {
    var c = cents + other.cents
    val d = dollars + other.dollars + c / 100
    c %= 100
    new Money(d, c)
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[Money]

  override def equals(other: Any): Boolean = other match {
    case that: Money =>
      (that canEqual this) &&
        dollars == that.dollars &&
        cents == that.cents
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(dollars, cents)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

object Money {

  def apply(dollars: Int, cents: Int): Money = {
    new Money(dollars, cents)
  }

}