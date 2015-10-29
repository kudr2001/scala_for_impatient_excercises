package inheritance8

import scala.collection.mutable

/**
 * Created by andrey on 24.09.15.
 */
class Bundle extends Item{

  val items = mutable.MutableList[Item]()

  def addItem(item : Item) = {
    items += item
  }

  def price() : Double = {
    var sum = 0.0

    for (item <- items)
      sum += item.price()

    sum
  }

  def description(): String = {
    val summary = new StringBuilder
    var i = 1

    summary ++= "Bundle: \n"

    for (item <- items) {
      summary ++= (i + ") " + item.description() + "\n")
      i += 1
    }

    summary ++= "------------: \nTotal: " + price() + "$"

    summary.toString()
  }

}
