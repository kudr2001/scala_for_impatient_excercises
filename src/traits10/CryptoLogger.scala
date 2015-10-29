package traits10

/**
 * Created by andrey on 05.10.15.
 */
trait CryptoLogger {

  var key: Int = 3

  def log(msg: String) = {

    val out = for (c <- msg) yield (c+key).toChar

    println(out)

  }

}

