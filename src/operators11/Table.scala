package operators11

import scala.collection.mutable.{ArrayBuffer}

/**
 * Created by andrey on 09.10.15.
 */
class Table {

  val trs = new ArrayBuffer[Tr]()

  def |(s: String) = {
    if (trs.length > 0)
      trs(trs.length-1).add(new Td(s))
    else
      trs += new Tr(new Td(s))
    this
  }

  def ||(s: String) = {
    trs += new Tr(new Td(s))
    this
  }

  override def toString = {

    val summary = new StringBuilder
    summary ++= "<table>"

    for (tr <- trs)
      summary ++= tr.toString

    summary ++= "</table>"
    summary.toString()
  }
}

object Table {

  def apply() = {
    new Table
  }

  def apply(td: Td) = {
    new Table() | td.name
  }

}

class Tr(td: Td) {

  val tds = ArrayBuffer[Td](td)

  def add(td: Td) {
    tds += td
  }

  override def toString = {
    var s = new StringBuilder("<tr>")
    for (td <- tds)
      s ++= td.toString
    s ++= "</tr>"
    s.toString()
  }

}

class Td(val name: String) {

  override def toString = {
    "<td>" + name + "</td>"
  }

}
