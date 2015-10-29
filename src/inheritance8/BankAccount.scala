package inheritance8

/**
 * Created by andrey on 24.09.15.
 */
class BankAccount(initialBalance: Double) {

  private var balance = initialBalance

  def currentBalance = balance

  def deposit(amount: Double) = { balance += amount; balance }

  def withdraw(amount: Double) = { balance -= amount; balance }

}

