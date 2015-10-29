package inheritance8

/**
  * Created by andrey on 24.09.15.
  */
class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance: Double) {

  private var transactionsCount = 0
  val INTEREST = 0.1
  val FREE_TRANSACTIONS_COUNT = 3

   override def withdraw(amount: Double) = {
     transactionsCount += 1
     super.withdraw(amount + (if (transactionsCount > FREE_TRANSACTIONS_COUNT) 1 else 0))
   }

   override def deposit(amount: Double) = {
     transactionsCount += 1
     super.deposit(amount + (if (transactionsCount > FREE_TRANSACTIONS_COUNT) 1 else 0))
   }

  def earnMonthlyInterest() = {
    super.deposit(currentBalance + currentBalance*INTEREST)
    transactionsCount = 0
  }

}
