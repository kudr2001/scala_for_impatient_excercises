package classes5

/**
 * Created by andrey on 18.09.15.
 */
class BankAccount {

  private var balance: Int = 0

  def current = balance

  def deposit(amount: Int) : Int = {
    balance += amount
    balance
  }

  def withdraw(amount: Int) : Int = {
    balance -= amount
    balance
  }

}
