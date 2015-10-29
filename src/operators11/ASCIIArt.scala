package operators11

import scala.collection.mutable.ArrayBuffer

/**
 * Created by andrey on 09.10.15.
 */
class ASCIIArt {

  val ascii = new ArrayBuffer[Array[String]]

  def |(f: Figure) = {
    if (ascii.length > 0) {
      val arr = ascii(ascii.length - 1)
      var i = 0
      while (i < arr.length) {
        arr(i) += f.s(i)
        i += 1
      }
    } else {
      ascii += f.s.clone()
    }
    this
  }

  def ||(f: Figure) = {
    // o_O ascii.last.last doesn't work
    ascii.last(ascii.last.length - 1) += "\n"
    ascii += f.s.clone()
    this
  }

  override def toString = {
    val res = new StringBuilder
    for (a <- ascii) {
      res ++= a.mkString("\n")
    }
    res.toString()
  }

}

object ASCIIArt {

  def apply() = {
    new ASCIIArt
  }

}

trait Figure {
  val s: Array[String]
}

object Cat extends Figure{
  val s = " /\\_/\\  \n( ' ' ) \n ( - )  \n | | |  \n(__|__) ".split("\n")
}

object Says extends Figure{
  val s = "   -----   \n / Hello \\ \n<  Scala | \n \\ Coder / \n   -----   ".split("\n")
}
