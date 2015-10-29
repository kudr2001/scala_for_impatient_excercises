package classes5

/**
 * Created by andrey on 18.09.15.
 */
object Classes {

  def intOverflow(): Unit = {
    val c = new Counter

    for (i <- 0 until Int.MaxValue - 1)
      c.increment()

    println(c.current)
    c.increment()
    println(c.current)
    c.increment()
    println(c.current)
    c.increment()
    println(c.current)
    c.increment()
    println(c.current)
  }

  def bank() = {
    val bankAccount = new BankAccount

    bankAccount.deposit(100)
    bankAccount.withdraw(78)

    println(bankAccount.current)
  }

  def time(): Unit = {
    val t = new Time(2, 4)

    println(t.before(new Time(3,4)))
    println(t.before(new Time(2,5)))
    println(t.before(new Time(2,4)))
    println(t.before(new Time(1,5)))
    println(t.before(new Time(1,4)))
    //println(t.before(new Time(25,25)))

    val t2 = new Time2(2, 4)

    println(t2.before(new Time2(3,4)))
    println(t2.before(new Time2(2,5)))
    println(t2.before(new Time2(2,4)))
    println(t2.before(new Time2(1,5)))
    println(t2.before(new Time2(1,4)))
    //println(t2.before(new Time2(25,25)))

  }

  def main(args: Array[String]): Unit = {

    //intOverflow()
    bank()
    time()

    val john = new Student("John", 23)
    john.setName("JJJ")
    println(john.getName)

  }

}
