package operators11

/**
 * Created by andrey on 12.10.15.
 */
class BitSequence(var src: Long) {

  def apply(bitIndex: Byte): Boolean = {
    (src & 1L << bitIndex) == (1L << bitIndex)
  }

  def update(bitIndex: Byte, up: Boolean) = {
    if (up)
      src = src | 1L << bitIndex
    else
      src = src & ~1L << bitIndex
  }

}
