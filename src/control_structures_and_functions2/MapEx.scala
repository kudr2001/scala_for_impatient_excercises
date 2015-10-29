package control_structures_and_functions2

import java.awt.datatransfer._
import java.util.{Calendar, TimeZone}

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.immutable.{SortedMap, HashMap}
import scala.collection.{mutable, TraversableLike}
import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.JavaConversions.propertiesAsScalaMap

/**
 * Created by andrey on 15.09.15.
 */
object MapEx {

  def discounts1(): Map[String, Double] = {
    val gizmos = Map("Yacht" -> 4000000.0, "Furniture" -> 500000.0, "RepairFlat" -> 1000000.0)
    for ((k, v) <- gizmos) yield (k, v*0.9) //Старый добрый цикл. Нихрена себе старый, в Java такое не сделаешь в одну строку
  }

  def discounts2(): Map[String, Double] = {
    val gizmos = Map("Yacht" -> 4000000.0, "Furniture" -> 500000.0, "RepairFlat" -> 1000000.0)
    gizmos.map( t => (t._1, t._2*0.9)) // Тут какое-то шаманство-оператор вроде _*2, с туплом
  }

  def discounts3(): Map[String, Double] = {
    val gizmos = Map("Yacht" -> 4000000.0, "Furniture" -> 500000.0, "RepairFlat" -> 1000000.0)
    gizmos.map{case (key, value) => (key, value * 0.9)} // Тут походу какая-то имплементация оператора какого-нибудь
  }

  def countTheWords(s: String, w: mutable.HashMap[String, Int]) : Unit = {
    for (e <- s.split(' ') if e.trim.nonEmpty) {
      w(e.trim) = w.getOrElse(e.trim, 0) + 1
    }
  }

  def wordCounter(): Unit = {
    val in = new java.util.Scanner(new java.io.File("/home/andrey/Документы/1.txt"))
    val wordsMap = new mutable.HashMap[String, Int]
    while (in.hasNext)
      countTheWords(in.next(), wordsMap)
    println(wordsMap.mkString("\n"))
  }

  def wordCounterImmutable(): Unit = {
    println("--------------------------- IMMUTABLE MAP: ---------------------------")
    val in = new java.util.Scanner(new java.io.File("/home/andrey/Документы/1.txt"))
    var wordsMap = new HashMap[String, Int]

    while (in.hasNext) {
      for (e <- in.next().split(' ') if e.trim.nonEmpty) {
        wordsMap = wordsMap + (e.trim -> (wordsMap.getOrElse(e.trim, 0) + 1))
      }
    }

    println(wordsMap.mkString("\n"))
  }

  def wordCounterSortedMap(): Unit = {
    println("--------------------------- SORTED MAP: ---------------------------")
    val in = new java.util.Scanner(new java.io.File("/home/andrey/Документы/1.txt"))
    var wordsMap = SortedMap[String, Int]()

    while (in.hasNext) {
      for (e <- in.next().split(' ') if e.trim.nonEmpty) {
        wordsMap = wordsMap + (e.trim -> (wordsMap.getOrElse(e.trim, 0) + 1))
      }
    }

    println(wordsMap.mkString("\n"))
  }

  def wordCounterTreeMap(): Unit = {
    println("--------------------------- TREE MAP: ---------------------------")
    val in = new java.util.Scanner(new java.io.File("/home/andrey/Документы/1.txt"))
    val wordsMap : scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]

    while (in.hasNext) {
      for (e <- in.next().split(' ') if e.trim.nonEmpty) {
        wordsMap(e.trim) = wordsMap.getOrElse(e.trim, 0) + 1
      }
    }

    println(wordsMap.mkString("\n"))
  }

  def week(): Unit = {
    val week = mutable.LinkedHashMap[String, Int]()
    week("Monday") = Calendar.MONDAY
    week("Tuesday") = Calendar.TUESDAY
    week("Wednesday") = Calendar.WEDNESDAY
    println(week.mkString(","))
  }

  def printProperties(): Unit = {
    val props: collection.Map[String, String] = System.getProperties
    var maxKey: String = ""
    for (k <- props.keySet) {
      if (k.length > maxKey.length)
        maxKey = k
    }

    println("Longest key is " + maxKey)

    for ((k, v) <- props) {
      println(k + " " * (maxKey.length - k.length) + "| " + v)
    }

  }

  def minmax(values: Array[Int]) : (Int, Int) = {
    (values.min, values.max)
  }

  def lteqgt(values: Array[Int], v: Int) : (Int, Int, Int) = {
    var lt, eq, gt = 0
    for (e <- values) {
      if (e == v)
        eq += 1
      else {
        if (e > v)
          gt += 1
        else
          lt += 1
      }
    }
    (lt, eq, gt)
  }

  def main(args: Array[String]) {

    println(discounts1().mkString(","))
    println(discounts2().mkString(","))
    println(discounts3().mkString(","))
    wordCounter()
    wordCounterImmutable()
    wordCounterSortedMap()
    week()
    printProperties()
    println(minmax(Array(1,2,4,567,9,4)))
    println(lteqgt(Array(1,2,4,567,9,4,0,9,8,4,5,34,23,3,1,2,3,4,5,6,7,8), 4))
    println("Hello".zip("World"))
  }

}
