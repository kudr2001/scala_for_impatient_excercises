package packages7

import com.horstmann.impatient.Employee

/**
 * Created by andrey on 23.09.15.
 */

object MainApp extends App{

  def copyMaps() {

    import collection.mutable.{HashMap => ScalaHashMap}
    import java.util.{HashMap => JavaHashMap}
    import scala.collection.JavaConversions.mapAsScalaMap

    def copyHashMap(jhm: JavaHashMap[Integer, String], shm: ScalaHashMap[Int, String]) {
      for ((k, v) <- jhm)
        shm.put(k, v)
    }

    val map = ScalaHashMap(1 -> "One", 2 -> "Two" )
    val jmap = new JavaHashMap[Integer, String]()
    jmap.put(3, "Three")

    copyHashMap(jmap, map)

    println("\n" + map.mkString(", "))

  }

  def pass(): Unit = {
    import java.lang.System._

    val name = getProperty("user.name")
    if (console() != null) {
      val pass = console().readPassword("Password: ")
      if (pass != "secret")
        err.println("The password is not secured!")
      else
        out.println("Greetings!")
    } else
      err.println("Cannot read pass from console")

  }

  println("Name of org.Emploee: " + new Employee().name)
  println("Name of org.horstmann.impatient.Emploee: " + new com.horstmann.impatient.Employee2().name)

  println(": " + new Employee().name)

  println("random ints:")
  for (i <- 1 to 20)
    print(random.nextInt() + "; ")

  println("\nrandom doubles:")
  random.setSeed(2)
  for (i <- 1 to 20)
    print(random.nextDouble() + "; ")

  copyMaps()
  pass()
}
