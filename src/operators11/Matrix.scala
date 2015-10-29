package operators11


/**
 * Created by andrey on 12.10.15.
 */
class Matrix(val m: Int, val n: Int) {

  //val matrix = ArrayBuffer.fill(m, n)(0)
  private val matrix = Array.ofDim[Int](m, n)
  //val matrix = Array.tabulate(m, n)((i,j)=>n*i+j)

  def +(other: Matrix): Matrix = {

    if (m != other.m || n != other.n)
      throw new Exception("While summing up the arrays dimensions must be the same")

    val out = new Matrix(m, n)
    for (i <- 0 until m) {
      for (j <- 0 until n) {
        out.matrix(i)(j) = matrix(i)(j) + other.matrix(i)(j)
      }
    }

    out
  }

  /*
    Array.tabulate(a.rows, b.cols)( {(row, col) =>
      (for(i <- 0 until a.cols) yield a.data(row)(i) * b.data(i)(col)) sum
    })
  */

  def *(other: Matrix): Matrix = {

    if (n != other.m)
      throw new Exception("To multiply an m×n matrix by an n×p matrix, the n must be the same, and the result is an m×p matrix")

    val out = new Matrix(m, other.n)

    for (i <- 0 until m) {
      for (j <- 0 until n) {
        for (k <- 0 until other.n) {
          out.matrix(i)(k) += matrix(i)(j) * other.matrix(j)(k)
        }
      }
    }

    out
  }

  def +(scalar: Int): Matrix = {
    new Matrix(matrix.map(_.map(_ + scalar)))
  }

  def *(scalar: Int): Matrix = {
    new Matrix(matrix.map(_.map(_ * scalar)))
  }

  def apply(row: Int, col: Int) = {
    matrix(row)(col)
  }

  def update(row: Int, col: Int, value: Int) = {
    matrix(row)(col) = value
  }

  def this(mat: Matrix) = {
    this(mat.m, mat.n)
    mat.matrix.copyToArray(matrix)
  }

  def this(arr: Array[Array[Int]]) = {
    this(arr.size, if (arr.size > 0) arr(0).size else 0)
    arr.copyToArray(matrix)
  }

  override def toString = {
    matrix.map(_.mkString(" ")).mkString("\n")
  }

}
