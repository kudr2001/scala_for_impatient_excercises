package operators11

import java.io.File

/**
 * Created by andrey on 12.10.15.
 */

class RichFile(pathname: String) extends File(pathname: String) {

  def unapply() = {
    val lastDotIndex = this.getName.lastIndexOf(".")
    if (lastDotIndex == -1) {
      new Triple(this.getParent, this.getName, "")
    } else {
      val name = this.getName.splitAt(lastDotIndex)
      new Triple(this.getParent, name._1, name._2.tail)
    }
  }

  def unapplySeq() = {
    this.getAbsolutePath.split("/").tail
  }

}
