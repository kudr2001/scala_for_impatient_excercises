package control_structures_and_functions2

import java.util.TimeZone

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import java.awt.datatransfer._
import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable.Buffer


/**
 * Created by andrey on 15.09.15.
 */
object ArrayEx {

  def removeAllButTheFirstNegative(a : ArrayBuffer[Int]): ArrayBuffer[Int] = {
    var first = true
    var n = a.length
    var i = 0
    while (i < n) {
      if (a(i) >= 0) i += 1
      else {
        if (first) { first = false; i += 1 }
        else { a.remove(i); n -= 1 }
      }
    }
    a
  }

  def removeAllButTheFirstNegative2(a : ArrayBuffer[Int]): ArrayBuffer[Int] = {

    var first = true
    val indexes = for (i <- 0 until a.length if first || a(i) >= 0) yield {
      if (a(i) < 0) first = false; i
    }

    for (j <- 0 until indexes.length)
      a(j) = a(indexes(j))

    a.trimEnd(a.length - indexes.length)

    a
  }

  def removeAllButTheFirstNegative3(a : ArrayBuffer[Int]): ArrayBuffer[Int] = {

    var negativeIndexesExceptFirst = for (i <- 0 until a.length if a(i) < 0) yield {
      i
    }

    negativeIndexesExceptFirst = negativeIndexesExceptFirst.tail.reverse

    for (j <- 0 until negativeIndexesExceptFirst.length)
      a.remove(negativeIndexesExceptFirst(j))

    a
  }

  def randomArr(n : Int): Array[Int] = {
    val a = new Array[Int](n)
    for (i <- 0 until n) yield a(i) = Random.nextInt()
    a
  }

  def randomArr2(n : Int): Array[Int] = {
    var a = new Array[Int](n)
    a.map(_ + Random.nextInt())
  }

  def swapAdjacent(a : Array[Int]): Array[Int] = {
    val r = for (i <- 0 until a.length) yield {
      if (i + 1 == a.length)
        a(i)
      else {
        if (i % 2 != 0)
          a(i - 1)
        else
          a(i + 1)
      }
    }

    r.toArray
  }

  def positiveNegative(a : Array[Int]): Array[Int] = {
    a.filter(_ > 0) ++ a.filter(_ <= 0)
  }

  def avg(a : Array[Double]): Double = {
    a.sum / a.length
  }

  def reversed(a : Array[Int]): Array[Int] = {
    a.reverse
  }

  def reversed(a : ArrayBuffer[Int]): ArrayBuffer[Int] = {
    a.reverse
  }

  def americanTimeZones(): Array[String] = {
    TimeZone.getAvailableIDs.filter(_.startsWith("America/")).sorted
  }

  def printFlavors() {
    val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
    val flavorsArr: mutable.Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
    println(flavorsArr.mkString(","))
  }

  def main(args: Array[String]) {

    println(randomArr(5).mkString(","))
    println(randomArr2(5).mkString(","))
    println(swapAdjacent(Array(1,2,3,4,5)).mkString(","))
    println(positiveNegative(Array(1,-2,-3,4,-5,6,7,8,-9,-10)).mkString(","))
    println(avg(Array(1.0,-2.0,-3.5,4.2,-5.55,6.23,7.90,8.4,-9.22,-10.3)))
    println(avg(Array(1.0,2.0)))
    println(reversed(Array(1,2)).mkString(","))
    println(reversed(ArrayBuffer(1,2)).mkString(","))
    println(Array(1,2,1,1,2,3,4,54,4,4,5).distinct.mkString(","))

    println(removeAllButTheFirstNegative(ArrayBuffer(1,-2,-3,4,-5,6,7,8,-9,-10)).mkString(","))
    println(removeAllButTheFirstNegative2(ArrayBuffer(1,-2,-3,4,-5,6,7,8,-9,-10)).mkString(","))
    println(removeAllButTheFirstNegative3(ArrayBuffer(1,-2,-3,4,-5,6,7,8,-9,-10)).mkString(","))

    println(americanTimeZones().mkString(","))
    printFlavors()
  }

}
