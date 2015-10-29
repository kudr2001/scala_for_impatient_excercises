/**
 * Created by andrey on 23.09.15.
 */
package object random {

  private var seedPrivate: Int = 1
  private[this] val a: Int = 1664525
  private[this] val b: Int = 1013904223
  private[this] val n = 32


  def nextInt() : Int = {
    val next = (seedPrivate * a + b) % Math.pow(2, n)
    seedPrivate = next.toInt
    next.toInt
  }

  def nextDouble() : Double = {
    val next = (seedPrivate * a + b) % Math.pow(2, n)
    seedPrivate = next.toInt
    next
  }

  def setSeed(seed: Int) : Unit = {
    seedPrivate = seed
  }


}
