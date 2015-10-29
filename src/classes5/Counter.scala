package classes5

/**
 * Created by andrey on 18.09.15.
 */
class Counter {

  private var value = 0

  def increment() {
    if (value == Int.MaxValue)
      value = 0
    else
      value += 1
  }

  def current = value

}
