package operators11

/**
 * Created by andrey on 08.10.15.
 */
object MainOperators extends App {

  def ex1Precedence() {
    println(3 + 4 -> 5)
    //println(3 -> 4 + 5) - couldn't compile. -> and + have the same precedence, so (3 -> 4) + 5 cannot be compiled (Pair plus 5)
  }

  def ex2Precedence() {
    val i = BigInt(5)
    println(i ^ 3) // Bitwise exclusive-or of BigInts
    //println(i ** 3) Note that ** neither ^ will not have the right precedence (that's the reason why the stdlib doesn't include it). 4*5**3 is (4*5)**3 and not 4*(5**3)
  }

  def ex3OperatorsFractions() = {
    println(Fraction(3, 4) + Fraction(5, 6))
    println(Fraction(3, 4) * Fraction(5, 6))
    println(Fraction(3, 4) / Fraction(5, 6))
    println(Fraction(3, 4) - Fraction(5, 6))
  }

  def ex4OperatorsMoney() = {
    println(Money(1, 75) + Money(0, 50) == Money(2, 25))

  }

  def ex5OperatorsTable() = {
    println(Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM, .NET")
  }

  def ex6AsciiArt() = {
    println(ASCIIArt() | Cat | Says | Cat | Says || Says | Cat)
  }

  def ex7BitSequence() = {
    val bs = new BitSequence(0)
    bs(2) = true
    bs(6) = true

    printf("BitSequence: bs(%d)=%b; bs(%d)=%b; bs(%d)=%b; bs(%d)=%b", 1, bs(1), 2, bs(2), 6, bs(6), 7, bs(7))

  }

  def ex8Matrices() = {
    val mat = new Matrix(Array.tabulate(2, 3)((i,j)=>3*i+j))
    val mat2 = new Matrix(Array.tabulate(2, 3)((i,j)=>3*i+j))

    val mat3 = new Matrix(Array.tabulate(2, 2)((i,j)=>2*i+j+1))
    val mat4 = new Matrix(Array(Array(2,0), Array(1,2)))

    println("mat:\n" + mat + "\n")
    println("mat2:\n" + mat3 + "\n")
    println("mat3:\n" + mat3 + "\n")
    println("mat4:\n" + mat4  + "\n")

    println("mat*2:\n" + (mat*2) + "\n")
    println("mat+3:\n" + (mat+3) + "\n")

    println("mat+mat2:\n" + (mat + mat2)  + "\n")
    println("mat3*mat4:\n" + (mat3 * mat4)  + "\n")
  }

  def ex9unapplyFilePath() = {
    val f = new RichFile("/home/andrey/floats.txt")

    println(f.unapply())
    println(f.unapplySeq().mkString(","))
  }

  //ex1Precedence()
  //ex2Precedence()
  //ex3OperatorsFractions()
  //ex4OperatorsMoney()
  //ex5OperatorsTable()
  //ex6AsciiArt()
  //ex7BitSequence()
  //ex8Matrices()
  ex9unapplyFilePath()
  //ex10 included in upper function
}
