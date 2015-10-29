package traits10

import classes5.BankAccount


/**
 * Created by andrey on 05.10.15.
 */
class SavingsAccount extends BankAccount with CryptoLogger {

  def this(k: Int) = {
    this()
    this.key = k
  }

  override def withdraw(amount: Int) = {
    if (amount > current)
      log("Insufficient funds")
    else
      super.withdraw(amount + 1)

    current
  }



}
