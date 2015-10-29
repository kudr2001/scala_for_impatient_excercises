package io9

import java.io.PrintWriter

import scala.io.Source

object Tabs extends App {

  val source = Source.fromFile("/home/andrey/tabs.txt")
  val lines = source.getLines().toArray
  source.close()

  for (l <- lines) {
    println(l)
  }


  //input: a string, an int representing the n-column bounds for tab-stops
  //output: a string with tabs replaced with spaces such that tabs end at
  //        nColumn indexes
  def tabReplace(line: String, nColumn: Int) = {
    var i = 0
    var output = line
    while(i < output.length) {
      if(output(i) == '\t') {
        //println("Found a tab!")
        val toAdd = i % nColumn
        output = output.take(i-1) + (" " + " " * (nColumn - toAdd)) + output.drop(i+1)
        i += (nColumn - toAdd)
      }
      i += 1
    }
    output
  }

  val out = new PrintWriter("/home/andrey/tabs.txt")

  var i = 0
  for (l <- lines) {
    out.println(tabReplace(l, 20))
    i += 1
  }

  out.close()
}
