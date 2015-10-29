package traits10

import java.io.{InputStream, FileInputStream, BufferedInputStream}

/**
 * Created by andrey on 08.10.15.
 */
trait BufferedInputStreamTrait extends InputStream with CryptoLogger{

  val bin = new BufferedInputStream(this)

  override def read(): Int = {
    log("Reading with buffer")
    bin.read()
  }

}
