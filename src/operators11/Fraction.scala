package operators11

/**
 * Created by andrey on 08.10.15.
 */
class Fraction(n: Int, d: Int) {

  private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d)
  private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d)
  override def toString = num + "/" + den
  def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0
  def gcd(a: Int, b: Int): Int = if (b == 0) Math.abs(a) else gcd(b, a % b)

  def norm(other: Fraction) = {
    val gcdResult = gcd(den, num % den)
    new Fraction(num/gcdResult, den/gcdResult)
  }

  def *(other: Fraction) = new Fraction(num * other.num, den * other.den)

  def /(other: Fraction) = new Fraction(num*other.den, if (den == 0 || other.num == 0) throw new ArithmeticException("Division by zero") else den * other.num)

  def +(other: Fraction) = new Fraction(
    num*other.den + other.num*den,
    den*other.den
  )

  def -(other: Fraction) = new Fraction(
    num*other.den - other.num*den,
    den*other.den
  )

}

object Fraction {
  def apply(n: Int, d: Int) = new Fraction(n, d)
}



