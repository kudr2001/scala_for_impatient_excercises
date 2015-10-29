package collections13

/**
 * Created by andrey on 15.10.15.
 */

import scala.collection._
import scala.io.Source

object CollectionsMain extends App {

  def ex1MapMutableSets() = {

    def indexes(s: String) = {

      val freq = mutable.Map[Char, mutable.SortedSet[Int]]()

      for (i <- 0 until s.length) {
        val c = s(i)
        freq(c) = freq.getOrElse(c, mutable.SortedSet[Int](i)) += i
      }

      freq
    }

    println(indexes("Mississipi"))

  }

  def ex2MapImmutableMapAndList() = {

    def indexes(s: String) = {
      (Map[Char, immutable.List[Int]]() /: s.zipWithIndex) {
        (m, sch) => m + (sch._1 -> (m.getOrElse(sch._1, immutable.List[Int]()) :+ sch._2))
      }
    }

    println(indexes("Mississipi"))

  }

  def ex3RemoveZeros() = {

    //mutable.LinkedList is deprecated
    //MutableList doesn't have remove operator

    def removeZeros(lst: List[Int]) = {
      lst.filter(_ != 0)
    }

    def removeZerosMutable(lst: mutable.ListBuffer[Int]) = {
      for (el <- lst; if el == 0)
        lst -= el
      lst
    }

    println(removeZeros(List(1, -2, 0, 7, -9)))
    println(removeZerosMutable(mutable.ListBuffer(1, -2, 0, 7, -9)))

  }

  def ex4FlatMap() = {

    def join(arr: Array[String], m: Map[String, Int]) = {
      //arr.map(m.getOrElse(_, -1)).filter(_ != -1).mkString(",")
      //flatMap concatenates only Some(Int) and not returns None. Very useful for map.get result arrays
      arr.flatMap(m.get).mkString(",")
    }

    println(join(Array("Tom", "Fred", "Harry"), Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)))

  }

  def ex5MkString() = {

    def mkString(arr: Array[String], sep: String) = {
      arr.reduceLeft(_ + sep + _)
    }

    println(mkString(Array("Tom", "Fred", "Harry"), ","))

  }

  def ex6ListsFolding() = {

    val lst = List(2, 4, 74, 3, -3)

    println((lst :\ List[Int]())(_ :: _))
    println((List[Int]() /: lst)(_ :+ _))

    println((List[Int]() /: lst)((x, y) => y +: x))

    //print(1 :: 2 :: Nil)

  }

  def ex7ZipsAndTuples() = {

    //val f = new Function2[Double, Int, Double] {
    val f = new ((Double, Int) => Double) {
      def apply(x: Double, y: Int): Double = x * y
    }

    val prices = List(5.0, 20.0, 9.95)
    val quantities = List(10, 2, 1)

    println((prices zip quantities).map{ f.tupled })

  }

  def ex8Arrays2Dim() = {

    def twoDimArray(arr: Array[Int], n: Int) = {
      arr.grouped(3)
    }

    println(twoDimArray(Array(1,2,3,4,5,6), 3).map(_.mkString(",")).mkString("\n"))

  }

  def ex10ParallelFrequences() = {

    val str = Source.fromFile("/home/andrey/myfile.txt", "UTF-8").mkString

    /*val frequencies = new scala.collection.mutable.HashMap[Char, Int]

    for (c <- str)
          frequencies(c) = frequencies.getOrElse(c, 0) + 1*/

    val frequencies = str.par.aggregate(mutable.Map[Char, Int]())(
      (m, c) => {m(c) = m.getOrElse(c, 0) + 1; m},
      (map1, map2) => map1 ++ map2.map{ case (k,v) => k -> (v + map1.getOrElse(k,0)) }
    )

    println(frequencies)

    //Map(S -> 3, e -> 5, n -> 11, h -> 7, M -> 3, 2 -> 3,   -> 8, 5 -> 2, P -> 1, t -> 7, b -> 2, 8 -> 2, A -> 2, s -> 4, . -> 6, m -> 5, d -> 6, I -> 4, U -> 2, C -> 2, 1 -> 3, g -> 2, a -> 24, 4 -> 3,
    //-> 5, W -> 2, i -> 11, r -> 5, N -> 2, c -> 1, 6 -> 1, 	 -> 12, u -> 4, l -> 3, 0 -> 4, 9 -> 2, T -> 3, o -> 5, 3 -> 3)
  }




  //ex1MapMutableSets()
  //ex2MapImmutableMapAndList()
  //ex3RemoveZeros()
  //ex4FlatMap()
  //ex5MkString()
  //ex6ListsFolding()
  //ex7ZipsAndTuples()
  //ex8Arrays2Dim()
  ex10ParallelFrequences()
}
