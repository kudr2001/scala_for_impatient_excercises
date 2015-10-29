package inheritance8

/**
 * Created by andrey on 24.09.15.
 */
object MainApp extends App {

  val bundle = new Bundle()

  bundle.addItem(new SimpleItem(48.0, "Snickers"))
  bundle.addItem(new SimpleItem(40.0, "Mars"))
  bundle.addItem(new SimpleItem(45.5, "Bounty"))

  println(bundle.description())

  println(new Ant().env.length)

}
