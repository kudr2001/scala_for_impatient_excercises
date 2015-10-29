package inheritance8

/**
 * Created by andrey on 24.09.15.
 */
class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance: Double) {
  override def withdraw(amount: Double) = {
    super.withdraw(amount + 1)
  }

  override def deposit(amount: Double) = {
    super.deposit(amount - 1)
  }
}
