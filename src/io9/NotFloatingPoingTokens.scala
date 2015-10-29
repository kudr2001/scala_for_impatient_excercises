package io9

import scala.io.Source

/**
 * Created by andrey on 02.10.15.
 */
object NotFloatingPoingTokens extends App {

  val floatsPattern = "^[-+]?[0-9]*\\.?[0-9]+$".r

  println(Source.fromFile("/home/andrey/tabs.txt").mkString.split("[ ,!?\t\n]+").filter(!floatsPattern.pattern.matcher(_).matches).mkString(","))


}
