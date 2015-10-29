package patternmatching14

import scala.io.Source

/**
 * Created by andrey on 28.10.15.
 */
object PatternMain extends App {

/*  1. Your Java Development Kit distribution has the source code for much of the JDK in the src.zip
  file. Unzip and search for case labels (regular expression case [^:]+:). Then look for comments
  starting with // and containing [Ff]alls? thr to catch comments such as // Falls through or // just
  fall thru. Assuming the JDK programmers follow the Java code convention, which requires such
  a comment, what percentage of cases falls through?*/
  def percentageOfFallsThrough() = {

    import java.nio.file._
    import java.io.File
    import scala.collection.JavaConversions._
    implicit def makeFileVisitor(f: (Path) => Unit) = new SimpleFileVisitor[Path] {
      override def visitFile(p: Path, attrs: attribute.BasicFileAttributes) = {
        f(p)
        FileVisitResult.CONTINUE
      }
    }

    var caseCount = 0
    var fallsThrough = 0

    def counter(f: Path): Unit = {
      if (f.toString.endsWith(".java")) {
        val br = Source.fromFile(f.toString).bufferedReader()
        val casePattern = ".*case [^:]+:.*".r
        val fallsThroughPattern = ".*//.*[Ff]alls? thr.*".r
        for (str <- Stream.continually(br.readLine()).takeWhile(_ != null)) {
          if (casePattern.pattern.matcher(str).matches)
            caseCount += 1
          if (fallsThroughPattern.pattern.matcher(str).matches)
            fallsThrough += 1
        }

        br.close()
      }
    }

    val dir = new File("/home/andrey/Загрузки/src-jdk")
    //Files.walkFileTree(dir.toPath, (f: Path) => println(f))

    Files.walkFileTree(dir.toPath, Set[FileVisitOption](FileVisitOption.FOLLOW_LINKS), 2024, counter _)
    printf("Cases count: %d, Falls through comments count: %d, Percentage: %.2f", caseCount, fallsThrough, 100.0*fallsThrough/caseCount )
  }


/*  2. Using pattern matching, write a function swap that receives a pair of integers and returns the pair
  with the components swapped.*/
  def swapEx() = {

    def swap(p: (Int, Int)) = {
      p match {
        case (x, y) => (y, x)
        case _ =>
      }
    }

    println(swap((1,2)))

  }

/*  3. Using pattern matching, write a function swap that swaps the first two elements of an array
  provided its length is at least two.*/
  def swapFirstTwoEx() = {

    def swapFirstTwo(arr: Array[Any]): Array[Any] = {
      arr match {
        case Array(x, y, rest @ _*) => Array(y, x) ++ rest
        case _ => Array.empty
      }
    }

    println(swapFirstTwo(Array(1,2,3,4)).mkString(","))

  }

  /*4. Add a case class Multiple that is a subclass of the Item class. For example, Multiple(10,
    Article("Blackwell Toaster", 29.95)) describes ten toasters. Of course, you should be able to handle
    any items, such as bundles or multiples, in the second argument. Extend the price function to
  handle this new case.*/
  def multiples() = {

    abstract class Item
    case class Article(description: String, price: Double) extends Item
    case class Bundle(description: String, discount: Double, items: Item*) extends Item
    case class Multiple(count: Int, item: Item) extends Item

    def price(it: Item): Double = it match {
      case Article(_, p) => p
      case Bundle(_, disc, its @ _*) => its.map(price).sum - disc
      case Multiple(c, i) => c*price(i)
    }

    printf("The price of bundle: %f", price(
      Multiple(10,
      Bundle("Father's day special", 20.0,
        Article("Scala for the Impatient", 39.95),
        Bundle("Anchor Distillery Sampler", 10.0,
          Article("Old Potrero Straight Rye Whiskey", 79.95),
          Article("Junípero Gin", 32.95))))))
  }


  //percentageOfFallsThrough()
  //swapEx()
  //swapFirstTwoEx()
  multiples()
}
