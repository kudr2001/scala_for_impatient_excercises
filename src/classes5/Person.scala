package classes5

/**
 * Created by andrey on 18.09.15.
 */
class Person(name: String, var age: Int) {

  private var fName, lName: String = null

  if (name.nonEmpty) {
    val n = name.trim.split(",")
    if (n.length > 1) {
      fName = n(0)
      lName = n(1)
    } else {
      throw new IllegalArgumentException("bad name")
    }

  }

  def firstName = fName
  def lastName = lName

  if (age < 0)
    age = 0

}

