package io9

import scala.io.Source

/**
 * Created by andrey on 01.10.15.
 */
object Quoted extends App {


  val qoutesPattern = "'([^\\\\']+|\\\\([btnfr\"'\\\\]|[0-3]?[0-7]{1,2}|u[0-9a-fA-F]{4}))*'|\"([^\\\\\"]+|\\\\([btnfr\"'\\\\]|[0-3]?[0-7]{1,2}|u[0-9a-fA-F]{4}))*\"".r

  for (matchString <- qoutesPattern.findAllIn(Source.fromFile("/home/andrey/quoted.txt").mkString))
    println(matchString.take(matchString.size-1).drop(1))


}
