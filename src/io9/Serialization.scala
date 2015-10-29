package io9

import inheritance8.Person

/**
 * Created by andrey on 02.10.15.
 */
object Serialization extends App {

  val fred = new Person("Fred")
  val joe = new Person("Joe")
  val mark = new Person("Mark")

  fred.friends = Array(joe, mark)
  mark.friends = Array(fred)

  import java.io._
  val out = new ObjectOutputStream(new FileOutputStream("test.obj"))
  out.writeObject(Array(fred, joe, mark))
  out.close()
  val in = new ObjectInputStream(new FileInputStream("test.obj"))
  val saved = in.readObject().asInstanceOf[Array[Person]]
  for (f <- saved) {
    println("\nName: " + f.name + "; Friends:" + f.friends.map(_.name).mkString(","))
  }

}

