package io9

import java.io.PrintWriter
import scala.math._

/**
 * Created by andrey on 01.10.15.
 */
object Reciprocal extends App {

  val out = new PrintWriter("/home/andrey/reciprocals.txt")

  for (e <- 0 to 20) {
    val exp = pow(2, e)
    out.println(exp + "\t\t" + 1/exp)
  }

  out.close()

}
