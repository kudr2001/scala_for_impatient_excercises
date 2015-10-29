package io9

import scala.io.Source

/**
 * Created by andrey on 02.10.15.
 */
object SrcFromUrl extends App {

  val numitemPattern = "<img.+?src=[\"'](.+?)[\"'].*?>".r

  //val str = """dfgdfg<img alt="" src="images/violet.jpg" style="border: 0px solid ; width: 73px; height: 76px;" title="">""" + "<img class=\"foo bar test\" title=\"test image\" src=\"http://example.com/img/image.jpg\" alt=\"test image\" width=\"100\" height=\"100\" />"

  val str = Source.fromURL("http://yandex.ru", "UTF-8").mkString

  for (numitemPattern(src) <- numitemPattern.findAllIn(str)) {
    println(src)
  }
}
