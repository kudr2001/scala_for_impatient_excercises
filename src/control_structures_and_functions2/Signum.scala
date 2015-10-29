package control_structures_and_functions2

/**
 * Created by andrey on 15.09.15.
 */
object Signum {

  def signum(p: Int) : Int = {
    if (p == 0) 0 else {
      if ( p > 0) 1 else -1
    }
  }

  def emptyFunction() = {}

  def countDown(n: Int): Unit = {
    for (i <- n to 0 by -1)
      println(i + " ")
  }

  def product(s: String): Long = {
    var prod: Long = 1
    for (c <- s) {
      println(c)
      prod *= c.toLong
    }
    prod
  }

  def product2(s: String): Long = {
    s.map(_.toLong).product
  }

  def product3(s: String): Long = {
      s(0) * (if (s.size > 1) product3(s.tail) else 1)
  }

  def power(x: Double, n: Int) : Double = {
    var p: Double = 0

    if (n == 0) p = 1
    else
      if (n < 0)
        p = 1 / power(x, -n)
      else {
        // n > 0
        if (n % 2 == 0) {
          p = power(x, n / 2)
          p *= p
        } else {
          p = x*power(x, n-1)
        }
      }

    p
  }

  def powerPrint(x: Double, from: Int, to: Int): Unit = {
    for (i <- from to to)
      printf("Power of %f^%d is %f\n", x, i, power(x, i))
  }

  def main(args: Array[String]) {
    println("signum of 10 is " + signum(10))
    println("signum of 0 is " + signum(0))
    println("signum of -510 is " + signum(-510))
    println("emptyFunction has value " + emptyFunction())
    countDown(11)
    println("the product of \"Hello\" " + product("Hello"))
    println("the product of \"He\" " + product("He"))
    printf("the product of \"Hello\" is %d\n", product2("Hello"))
    printf("the recursive product of \"Hello\" is %d\n", product3("Hello"))
    powerPrint(2, -5, 15)
    powerPrint(2.56, -5, 15)
  }

}
