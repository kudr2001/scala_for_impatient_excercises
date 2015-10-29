package io9

/**
 * Created by andrey on 01.10.15.
 */
object LinesInverter extends App {

  import scala.io.Source
  val source = Source.fromFile("/home/andrey/myfile.txt", "UTF-8")
  // The first argument can be a string or a java.io.File
  // You can omit the encoding if you know that the file uses
  // the default platform encoding

  val lines = source.getLines().toArray.reverse

  for (l <- lines) {
    println(l)
  }



}
