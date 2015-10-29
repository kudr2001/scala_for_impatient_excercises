package inheritance8

/**
 * Created by andrey on 24.09.15.
 */
class Person(val name: String) extends Serializable {

  var friends: Array[Person] = Array()

  override def toString = getClass.getName + "[name=" + name + "]"

}

