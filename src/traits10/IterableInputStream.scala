package traits10

import java.io.{FileInputStream, InputStream}

/**
 * Created by andrey on 08.10.15.
 */
class IterableInputStream(name: String) extends FileInputStream(name: String) with Iterable[Byte]{

  val _iterator: Iterator[Byte] = new Iterator[Byte]() {
    override def hasNext: Boolean = available != 0

    override def next(): Byte = {
      if (hasNext) {
        read().toByte
      } else {
        Iterator.empty.next()
      }
    }
  }

  override def read(): Int = {
    super.read()
  }

  override def iterator: Iterator[Byte] = {
    _iterator
  }

}
