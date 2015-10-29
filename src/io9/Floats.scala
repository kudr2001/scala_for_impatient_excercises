package io9

import scala.io.Source

/**
 * Created by andrey on 01.10.15.
 */
object Floats extends App {

  val floats = Source.fromFile("/home/andrey/floats.txt").mkString.split("[ ,!?\t\n]+").map(_.toDouble)

  printf("Min: %f; Max: %f; Sum: %f; Avg: %5f", floats.min, floats.max, floats.sum, floats.sum/floats.size)
}
