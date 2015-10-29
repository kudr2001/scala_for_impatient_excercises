package highorderfunctions12

import scala.collection.GenSeq

/**
 * Created by andrey on 14.10.15.
 */
object FunctionsMain extends App {

  def ex1() = {

    def values(fun: (Int) => Int, low: Int, high: Int) = {

      /*def f(x: Int) = {
        (x, fun(x))
      }*/

      (low to high).map( x => (x, fun(x)) )
    }

    println(values(x => x * x, -5, 5))

  }

  def ex2() = {
    val arr = Array(1,2,22,4,5)
    println(arr.reduceLeft(math.max))
    println(arr.max)
  }

  def factorial3(n: Int) = {
    if (n > 0) {
      println((1 to n).reduceLeft(_*_))
      println((1 to n).product)
    } else if (n == 0) {
      println((1 to n).foldLeft(1)(_*_))
    } else {
      throw new Exception("n must be greater then or equal to 0")
    }
  }

  def factorial4(n: Int) = {
    println((1 to n).foldLeft(1)(_*_))
  }

  def largest5() = {

    def largest(fun: (Int) => Int, inputs: Seq[Int]) = {
      inputs.map(fun).max
    }

    println(largest(x => 10 * x - x * x, 1 to 10))

  }

  def largestAt6() = {

    def largestAt(fun: (Int) => Int, inputs: Seq[Int]) = {
      inputs.maxBy(fun) //Finds the first element which yields the largest value measured by function f.
    }

    println(largestAt(x => 10 * x - x * x, 1 to 10))

  }

  def adjustToPair7() = {

    def adjustToPair(f:(Int, Int) => Int)(t: (Int, Int)) = {
      f(t._1, t._2)
    }

    val pairs = (1 to 10) zip (11 to 20)
    //adjustToPair(_ * _)((6, 7)) = 42

    println(pairs.map(adjustToPair(_ + _)).sum)

  }

  def corresponds8() = {

    val a = Array("Hello", "World")
    val b = Array(5, 5)

    println(a.corresponds(b)(_.length == _))

  }

  def corresponds9() = {

    def corresponds[A, B](that: GenSeq[B], thisObj: GenSeq[A], p: (A,B) => Boolean): Boolean = {
      val i = thisObj.iterator
      val j = that.iterator
      while (i.hasNext && j.hasNext)
        if (!p(i.next(), j.next()))
          return false

      !i.hasNext && !j.hasNext
    }

    val a = Array("Hello", "World")
    val b = Array(5, 5)

    //def corresponds[B](that: GenSeq[B])(p: (A,B) => Boolean): Boolean
    println(corresponds(b, a, (x: String, y: Int) => x.length == y))

  }

  def unless10() = {

    def unless(condition: => Boolean)(block: => Unit) = {
      if (!condition) {
        block
      }
    }

    val x = 9
    unless(x == 10) {
      println("x != 10")
    }

    unless(x == 10)(println("x != 10"))

  }




  //ex1()
  //ex2()
  //factorial3(5)
  //factorial4(0)
  //largest5()
  //largestAt6()
  //adjustToPair7()
  //corresponds8()
  //corresponds9()
  unless10()

}
