package io9


/**
 * Created by andrey on 02.10.15.
 */
object DirectoryList extends App {


/* JAVA 7: import java.nio.file._
  implicit def makeFileVisitor(f: (Path) => Unit) = new SimpleFileVisitor[Path] {
    override def visitFile(p: Path, attrs: attribute.BasicFileAttributes) = {
      f(p)
      FileVisitResult.CONTINUE
    }
  }
  Files.walkFileTree(dir.toPath, (f: Path) => println(f))*/

  import java.io.File

  def classFiles(dir: File): Iterator[File] = {
    val children = dir.listFiles.filter(_.getName.endsWith(".class"))
    children.toIterator
  }

  for (d <- classFiles(new File("/home/andrey/work/scalademo/out/production/scalademo/inheritance8"))) {
    println(d.getName)
  }

}
