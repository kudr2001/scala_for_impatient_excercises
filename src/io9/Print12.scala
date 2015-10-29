package io9

import scala.io.Source

/**
 * Created by andrey on 01.10.15.
 */
object Print12 extends App {

  println(Source.fromFile("/home/andrey/tabs.txt").mkString.split("[ ,!?\t\n]+").filter(_.length > 6).mkString(","))


}
