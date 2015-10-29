package traits10

import java.awt.Point
import java.io.{FileInputStream, File}

/**
 * Created by andrey on 05.10.15.
 */
object MainTrait extends App {

  def ellipseFix() = {

    val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
    printf("Egg: x=%f; y=%f; width=%f; height=%f\n", egg.x, egg.y, egg.width, egg.height)
    egg.translate(10, -10)
    printf("Translated Egg: x=%f; y=%f; width=%f; height=%f\n", egg.x, egg.y, egg.width, egg.height)
    egg.grow(10, 20)
    printf("Grown Egg: x=%f; y=%f; width=%f; height=%f\n", egg.x, egg.y, egg.width, egg.height)

    val regg = new java.awt.Rectangle(15, 0, 20, 30)
    regg.grow(10, 20)
    printf("Grown Rect: x=%d; y=%d; width=%d; height=%d\n", regg.x, regg.y, regg.width, regg.height)

  }

  def orderedPoint() = {

    val oP = new OrderedPoint(10, 10)
    val oP2 = new OrderedPoint(11, 11)
    val oP3 = new OrderedPoint(9, 9)
    val oP4 = new OrderedPoint(10, 20)

    println("oP.compare(oP2)=" + oP.compare(oP2))
    println("oP.compare(oP3)=" + oP.compare(oP3))
    println("oP.compare(oP)=" + oP.compare(oP))
    println("oP.compare(oP4)=" + oP.compare(oP4))

  }

  def cryptoLogger() = {

    val savingsAccount = new SavingsAccount()
    savingsAccount.withdraw(100)

    val savingsAccount2 = new SavingsAccount(-3)
    savingsAccount2.withdraw(100)

    val savingsAccount3 = new SavingsAccount(0)
    savingsAccount3.withdraw(100)

  }

  def pointWithPropertyListenerTrait() = {

    val p = new Point() with BoundPropertyBean {

      override def move(x: Int, y: Int): Unit = {
        val xOld = this.getX
        val yOld = this.getY
        super.move(x, y)
        firePropertyChange("x", xOld, x)
        firePropertyChange("y", yOld, y)
      }

      override def setLocation(x: Double, y: Double): Unit =
      {
        val xOld = this.getX
        val yOld = this.getY
        super.setLocation(x, y)
        firePropertyChange("x", xOld, x)
        firePropertyChange("y", yOld, y)
      }

      override def translate(dx: Int, dy: Int): Unit = {
        val xOld = this.getX
        val yOld = this.getY
        super.translate(dx, dy)
        firePropertyChange("x", xOld, dx)
        firePropertyChange("y", yOld, dy)
      }


    }
    p.addPropertyChangeListener(PCL)

    p.x = 10
    p.move(1,2)

    println(p)

  }

  def readFileWithBuffer() = {

    val file = new File("/home/andrey/floats.txt")
    val fin1 = new FileInputStream(file) with BufferedInputStreamTrait

    println("Reading file:" + fin1.read())

  }

  def readInputStreamIterable() = {

    val fin1: IterableInputStream = new IterableInputStream("/home/andrey/floats.txt")

    println("Reading file with IterableInputStream: " + fin1.iterator.mkString(","))

  }

  //ellipseFix()
  //orderedPoint()
  //cryptoLogger()
  //pointWithPropertyListenerTrait()
  //readFileWithBuffer()
  readInputStreamIterable()
  /*
  BitSet - class

  1) trait BitSet extends SortedSet[Int]
                with BitSetLike[BitSet]

  2) object BitSet extends BitSetFactory[BitSet]

  3) class BitSet(protected final var elems: Array[Long]) extends AbstractSet[Int]
                                                  with SortedSet[Int]
                                                  with scala.collection.BitSet
                                                  with BitSetLike[BitSet]
                                                  with SetLike[Int, BitSet]
                                                  with Serializable

  lin(BitSet) = BitSet >> lin(Serializable) >> lin(SetLike) >> lin(BitSetLike) >> lin(scala.collection.BitSet) >> lin(SortedSet) >> lin(AbstractSet)

  lin(BitSet) = BitSet >> (Serializable >> java.io.Serializable) >> lin(SetLike) >> lin(BitSetLike) >> lin(scala.collection.BitSet) >> lin(SortedSet) >> lin(AbstractSet)

  (SetLike >> lin(Set) >> lin(Set) >> lin(Parallelizable) >> lin(Subtractable) >> lin(GenSetLike) >> lin(IterableLike))
trait SetLike[A, +This <: SetLike[A, This] with Set[A]]
extends IterableLike[A, This]
   with GenSetLike[A, This]
   with Subtractable[A, This]
   with Parallelizable[A, ParSet[A]]

lin(BitSet) = BitSet >> (Serializable >> java.io.Serializable) >> lin(SetLike >> lin(Set) >> lin(Set) >> lin(Parallelizable) >> lin(Subtractable) >> lin(GenSetLike) >> lin(IterableLike)) >> lin(BitSetLike) >> lin(scala.collection.BitSet) >> lin(SortedSet) >> lin(AbstractSet)

   trait BitSetLike[+This <: BitSetLike[This] with SortedSet[Int]] extends SortedSetLike[Int, This]
   (BitSetLike >> lin(SortedSet) >> lin(SortedSetLike))

lin(BitSet) = BitSet >> (Serializable >> java.io.Serializable) >> lin(SetLike >> lin(Set) >> lin(Set) >> lin(Parallelizable) >> lin(Subtractable) >> lin(GenSetLike) >> lin(IterableLike)) >> (BitSetLike >> lin(SortedSet) >> lin(SortedSetLike)) >> lin(scala.collection.BitSet) >> lin(SortedSet) >> lin(AbstractSet)

trait BitSet extends SortedSet[Int] with BitSetLike[BitSet]
(BitSet >> lin(BitSetLike) >> lin(SortedSet))

lin(BitSet) = BitSet >> (Serializable >> java.io.Serializable) >> lin(SetLike >> lin(Set) >> lin(Set) >> lin(Parallelizable) >> lin(Subtractable) >> lin(GenSetLike) >> lin(IterableLike)) >> (BitSetLike >> lin(SortedSet) >> lin(SortedSetLike)) >> (BitSet >> lin(BitSetLike) >> lin(SortedSet)) >> lin(SortedSet) >> lin(AbstractSet)

trait SortedSet[A] extends Set[A] with SortedSetLike[A, SortedSet[A]]
(SortedSet >> lin(SortedSetLike) >> lin(Set))

lin(BitSet) = BitSet >> (Serializable >> java.io.Serializable) >> lin(SetLike >> lin(Set) >> lin(Set) >> lin(Parallelizable) >> lin(Subtractable) >> lin(GenSetLike) >> lin(IterableLike)) >> (BitSetLike >> lin(SortedSet) >> lin(SortedSetLike)) >> (BitSet >> lin(BitSetLike) >> lin(SortedSet)) >> (SortedSet >> lin(SortedSetLike) >> lin(Set)) >> lin(AbstractSet)


//Подчистим

lin(BitSet) = BitSet >> (Serializable >> java.io.Serializable) >> lin(SetLike >> lin(Set) >> lin(Parallelizable) >> lin(Subtractable) >> lin(GenSetLike) >> lin(IterableLike)) >> (BitSetLike >> lin(SortedSet) >> lin(SortedSetLike)) >> (BitSet >> lin(BitSetLike) >> lin(SortedSet)) >> (SortedSet >> lin(SortedSetLike) >> lin(Set)) >> lin(AbstractSet)


trait Set[A] extends (A => Boolean)
                with Iterable[A]
                with GenSet[A]
                with GenericSetTemplate[A, Set]
                with SetLike[A, Set[A]]
(Set >> lin(SetLike) >> lin(GenericSetTemplate) >> lin(GenSet) >> lin(Iterable) >> (A => Boolean))

lin(BitSet) = BitSet >> (Serializable >> java.io.Serializable) >> lin(Parallelizable) >> lin(Subtractable) >> lin(GenSetLike) >> lin(IterableLike)) >> (BitSetLike >> lin(SortedSet) >> lin(SortedSetLike)) >> (BitSet >> lin(BitSetLike) >> lin(SortedSet)) >> (SortedSet >> lin(SortedSetLike) >> (Set >> lin(SetLike) >> lin(GenericSetTemplate) >> lin(GenSet) >> lin(Iterable) >> (A => Boolean))) >> lin(AbstractSet)

trait GenSetLike[A, +Repr]
extends GenIterableLike[A, Repr]
   with (A => Boolean)
   with Equals
   with Parallelizable[A, parallel.ParSet[A]]

(GenSetLike >> Parallelizable >> lin(Equals) >> lin((A => Boolean)) >> GenIterableLike)

lin(BitSet) = BitSet >> (Serializable >> java.io.Serializable) >> lin(Subtractable) >> (GenSetLike >> Parallelizable >> lin(Equals)) >> GenIterableLike) >> lin(IterableLike)) >> (BitSet >> BitSetLike) >> (SortedSet >> lin(SortedSetLike) >> (Set >> lin(SetLike) >> lin(GenericSetTemplate) >> lin(GenSet) >> lin(Iterable) >> (A => Boolean))) >> lin(AbstractSet)

trait GenSet[A]
extends GenSetLike[A, GenSet[A]]
   with GenIterable[A]
   with GenericSetTemplate[A, GenSet]

(GenSet >> lin(GenericSetTemplate) >> lin(GenIterable) >> lin(GenSetLike))

lin(BitSet) = BitSet >> (Serializable >> java.io.Serializable) >> lin(Subtractable) >> lin(IterableLike)) >> (BitSet >> BitSetLike) >> (SortedSet >> lin(SortedSetLike) >> (Set >> lin(SetLike) >> lin(GenericSetTemplate) >> (GenSet >> lin(GenericSetTemplate) >> lin(GenIterable) >> (GenSetLike >> Parallelizable >> lin(Equals)) >> lin(GenIterableLike))) >> lin(Iterable) >> (A => Boolean))) >> lin(AbstractSet)

trait Iterable[+A] extends Traversable[A]
                      with GenIterable[A]
                      with GenericTraversableTemplate[A, Iterable]
                      with IterableLike[A, Iterable[A]]

(Iterable >> lin(IterableLike) >> lin(GenericTraversableTemplate)>> lin(GenIterable)>> lin(Traversable))

lin(BitSet) = BitSet >> (Serializable >> java.io.Serializable) >> lin(Subtractable) >> lin(IterableLike)) >> (BitSet >> BitSetLike) >> (SortedSet >> lin(SortedSetLike) >> (Set >> lin(SetLike) >> lin(GenericSetTemplate) >> (GenSet >> lin(GenericSetTemplate) >> lin(GenIterable) >> (GenSetLike >> Parallelizable >> lin(Equals)) >> lin(GenIterableLike))) >> (Iterable >> lin(IterableLike) >> lin(GenericTraversableTemplate)>> lin(GenIterable)>> lin(Traversable)) >> (A => Boolean))) >> lin(AbstractSet)

trait Traversable[+A] extends TraversableLike[A, Traversable[A]]
                         with GenTraversable[A]
                         with TraversableOnce[A]
                         with GenericTraversableTemplate[A, Traversable]

(Traversable >> lin(GenericTraversableTemplate) >> lin(TraversableOnce) >> lin(GenTraversable) >> lin(TraversableLike))

lin(BitSet) = BitSet >> (Serializable >> java.io.Serializable) >> lin(Subtractable) >> lin(IterableLike)) >> (BitSet >> BitSetLike) >> (SortedSet >> lin(SortedSetLike) >> (Set >> lin(SetLike) >> lin(GenericSetTemplate) >> (GenSet >> lin(GenericSetTemplate) >> lin(GenIterable) >> (GenSetLike >> Parallelizable >> lin(Equals)) >> lin(GenIterableLike))) >> (Iterable >> lin(IterableLike) >> lin(GenericTraversableTemplate)>> lin(GenIterable)>> (Traversable >> lin(GenericTraversableTemplate) >> lin(TraversableOnce) >> lin(GenTraversable) >> lin(TraversableLike))) >> (A => Boolean))) >> lin(AbstractSet)

trait TraversableLike[+A, +Repr] extends Any
                                    with HasNewBuilder[A, Repr]
                                    with FilterMonadic[A, Repr]
                                    with TraversableOnce[A]
                                    with GenTraversableLike[A, Repr]
                                    with Parallelizable[A, ParIterable[A]]
(TraversableLike >> Parallelizable >> lin(GenTraversableLike) >> lin(TraversableOnce) >> lin(FilterMonadic) >> lin(HasNewBuilder))

lin(BitSet) = BitSet >> (Serializable >> java.io.Serializable) >> lin(Subtractable) >> lin(IterableLike)) >> (BitSet >> BitSetLike) >> (SortedSet >> lin(SortedSetLike) >> (Set >> lin(SetLike) >> lin(GenericSetTemplate) >> (GenSet >> lin(GenericSetTemplate) >> lin(GenIterable) >> (GenSetLike >> lin(Equals)) >> lin(GenIterableLike))) >> (Iterable >> lin(IterableLike) >> lin(GenericTraversableTemplate)>> lin(GenIterable)>> (Traversable >> lin(GenericTraversableTemplate) >> lin(TraversableOnce) >> lin(GenTraversable) >> (TraversableLike >> Parallelizable >> lin(GenTraversableLike) >> lin(TraversableOnce) >> FilterMonadic >> HasNewBuilder) )) >> (A => Boolean))) >> lin(AbstractSet)

trait TraversableOnce[+A] extends Any with GenTraversableOnce[A]

(TraversableOnce >> lin(GenTraversableOnce))


lin(BitSet) = BitSet >> (Serializable >> java.io.Serializable) >> lin(Subtractable) >> lin(IterableLike)) >> (BitSet >> BitSetLike) >> (SortedSet >> lin(SortedSetLike) >> (Set >> lin(SetLike) >> lin(GenericSetTemplate) >> (GenSet >> lin(GenericSetTemplate) >> lin(GenIterable) >> (GenSetLike >> lin(Equals)) >> lin(GenIterableLike))) >> (Iterable >> lin(IterableLike) >> lin(GenericTraversableTemplate)>> lin(GenIterable)>> (Traversable >> lin(GenericTraversableTemplate) >> lin(TraversableOnce) >> lin(GenTraversable) >> (TraversableLike >> Parallelizable >> lin(GenTraversableLike) >> (TraversableOnce >> GenTraversableOnce) >> FilterMonadic >> HasNewBuilder) )) >> (A => Boolean))) >> lin(AbstractSet)

trait GenTraversableLike[+A, +Repr] extends Any with GenTraversableOnce[A] with Parallelizable[A, parallel.ParIterable[A]]

(GenTraversableLike >> Parallelizable >> GenTraversableOnce)

lin(BitSet) = BitSet >> (Serializable >> java.io.Serializable) >> lin(Subtractable) >> lin(IterableLike)) >> (BitSet >> BitSetLike) >> (SortedSet >> lin(SortedSetLike) >> (Set >> lin(SetLike) >> lin(GenericSetTemplate) >> (GenSet >> lin(GenericSetTemplate) >> lin(GenIterable) >> (GenSetLike >> lin(Equals)) >> lin(GenIterableLike))) >> (Iterable >> lin(IterableLike) >> lin(GenericTraversableTemplate)>> lin(GenIterable)>> (Traversable >> lin(GenericTraversableTemplate) >> lin(TraversableOnce) >> lin(GenTraversable) >> (TraversableLike >> Parallelizable >> (GenTraversableLike >> Parallelizable >> GenTraversableOnce) >> (TraversableOnce >> GenTraversableOnce) >> FilterMonadic >> HasNewBuilder) )) >> (A => Boolean))) >> lin(AbstractSet)

lin(BitSet) = BitSet >> (Serializable >> java.io.Serializable) >> lin(Subtractable) >> lin(IterableLike)) >> (BitSet >> BitSetLike) >> (SortedSet >> lin(SortedSetLike) >> (Set >> lin(SetLike) >> lin(GenericSetTemplate) >> (GenSet >> lin(GenericSetTemplate) >> lin(GenIterable) >> (GenSetLike >> lin(Equals)) >> lin(GenIterableLike))) >> (Iterable >> lin(IterableLike) >> lin(GenericTraversableTemplate)>> lin(GenIterable)>> (Traversable >> lin(GenericTraversableTemplate) >> (GenTraversable >> lin(GenericTraversableTemplate)) >> (TraversableLike >> Parallelizable >> GenTraversableLike >> TraversableOnce >> GenTraversableOnce >> FilterMonadic >> HasNewBuilder) )) >> (A => Boolean))) >> lin(AbstractSet)

trait GenTraversable[+A]
extends GenTraversableLike[A, GenTraversable[A]]
   with GenTraversableOnce[A]
   with GenericTraversableTemplate[A, GenTraversable]

(GenTraversable >> lin(GenericTraversableTemplate) >> GenTraversableOnce >> lin(GenTraversableLike))

trait GenericTraversableTemplate[+A, +CC[X] <: GenTraversable[X]] extends HasNewBuilder[A, CC[A] @uncheckedVariance]

(GenericTraversableTemplate >> HasNewBuilder)

lin(BitSet) = BitSet >> (Serializable >> java.io.Serializable) >> lin(Subtractable) >> lin(IterableLike)) >> (BitSet >> BitSetLike) >> (SortedSet >> lin(SortedSetLike) >> (Set >> lin(SetLike) >> lin(GenericSetTemplate) >> (GenSet >> lin(GenericSetTemplate) >> lin(GenIterable) >> (GenSetLike >> lin(Equals)) >> lin(GenIterableLike))) >> (Iterable >> lin(IterableLike) >> lin(GenIterable)>> Traversable >> GenTraversable >> GenericTraversableTemplate >> TraversableLike >> Parallelizable >> GenTraversableLike >> TraversableOnce >> GenTraversableOnce >> FilterMonadic >> HasNewBuilder >> (A => Boolean) >> lin(AbstractSet)

trait GenIterable[+A]
extends GenIterableLike[A, GenIterable[A]]
   with GenTraversable[A]
   with GenericTraversableTemplate[A, GenIterable]
(GenIterable >> lin(GenTraversable) >> GenericTraversableTemplate)

lin(BitSet) = BitSet >> (Serializable >> java.io.Serializable) >> lin(Subtractable) >> lin(IterableLike)) >> (BitSet >> BitSetLike) >> (SortedSet >> lin(SortedSetLike) >> (Set >> lin(SetLike) >> lin(GenericSetTemplate) >> (GenSet >> lin(GenericSetTemplate) >> (GenSetLike >> lin(Equals)) >> lin(GenIterableLike))) >> (Iterable >> lin(IterableLike) >> GenIterable >> Traversable >> GenTraversable >> GenericTraversableTemplate >> TraversableLike >> Parallelizable >> GenTraversableLike >> TraversableOnce >> GenTraversableOnce >> FilterMonadic >> HasNewBuilder >> (A => Boolean) >> lin(AbstractSet)

trait IterableLike[+A, +Repr] extends Any with Equals with TraversableLike[A, Repr] with GenIterableLike[A, Repr]
(IterableLike >> lin(GenIterableLike) >> lin(TraversableLike))

lin(BitSet) = BitSet >> (Serializable >> java.io.Serializable) >> lin(Subtractable) >> lin(IterableLike)) >> (BitSet >> BitSetLike) >> (SortedSet >> lin(SortedSetLike) >> (Set >> lin(SetLike) >> lin(GenericSetTemplate) >> (GenSet >> lin(GenericSetTemplate) >> (GenSetLike >> lin(Equals)) >> lin(GenIterableLike))) >> (Iterable >> (IterableLike >> lin(GenIterableLike) >> lin(TraversableLike)) >> GenIterable >> Traversable >> GenTraversable >> GenericTraversableTemplate >> TraversableLike >> Parallelizable >> GenTraversableLike >> TraversableOnce >> GenTraversableOnce >> FilterMonadic >> HasNewBuilder >> (A => Boolean) >> lin(AbstractSet)

lin(BitSet) = BitSet >> (Serializable >> java.io.Serializable) >> lin(Subtractable) >> lin(IterableLike)) >> (BitSet >> BitSetLike) >> (SortedSet >> lin(SortedSetLike) >> (Set >> lin(SetLike) >> lin(GenericSetTemplate) >> (GenSet >> lin(GenericSetTemplate) >> (GenSetLike >> lin(Equals)))) >> (Iterable >> (IterableLike >> lin(GenIterableLike)) >> GenIterable >> Traversable >> GenTraversable >> GenericTraversableTemplate >> TraversableLike >> Parallelizable >> GenTraversableLike >> TraversableOnce >> GenTraversableOnce >> FilterMonadic >> HasNewBuilder >> (A => Boolean) >> lin(AbstractSet)

trait GenIterableLike[+A, +Repr] extends Any with GenTraversableLike[A, Repr] {
(GenIterableLike >> GenTraversableLike)

lin(BitSet) = BitSet >> (Serializable >> java.io.Serializable) >> lin(Subtractable)) >> (BitSet >> BitSetLike) >> (SortedSet >> lin(SortedSetLike) >> (Set >> lin(SetLike) >> GenSet >> GenericSetTemplate >> GenSetLike >> Iterable >> IterableLike >> GenIterableLike >> Equals >> GenIterable >> Traversable >> GenTraversable >> GenericTraversableTemplate >> TraversableLike >> Parallelizable >> GenTraversableLike >> TraversableOnce >> GenTraversableOnce >> FilterMonadic >> HasNewBuilder >> (A => Boolean) >> lin(AbstractSet)

trait Iterable[+A] extends Traversable[A]
                      with GenIterable[A]
                      with GenericTraversableTemplate[A, Iterable]
                      with IterableLike[A, Iterable[A]]

lin(SetLike)
trait SetLike[A, +This <: SetLike[A, This] with Set[A]]
extends IterableLike[A, This]
   with GenSetLike[A, This]
   with Subtractable[A, This]
   with Parallelizable[A, ParSet[A]]

   (SetLike >> Parallelizable >> Subtractable >> Set)

lin(BitSet) = BitSet >> (Serializable >> java.io.Serializable) >> lin(Subtractable)) >> (BitSet >> BitSetLike) >> (SortedSet >> lin(SortedSetLike) >> SetLike >> Subtractable >> Set >> GenSet >> GenericSetTemplate >> GenSetLike >> Iterable >> IterableLike >> GenIterableLike >> Equals >> GenIterable >> Traversable >> GenTraversable >> GenericTraversableTemplate >> TraversableLike >> Parallelizable >> GenTraversableLike >> TraversableOnce >> GenTraversableOnce >> FilterMonadic >> HasNewBuilder >> (A => Boolean) >> lin(AbstractSet)

trait SortedSetLike[A, +This <: SortedSet[A] with SortedSetLike[A, This]] extends Sorted[A, This] with SetLike[A, This]
(SortedSetLike >> SetLike >> Sorted )

lin(BitSet) = BitSet >> (Serializable >> java.io.Serializable) >> lin(Subtractable)) >> (BitSet >> BitSetLike) >> SortedSet >> SortedSetLike >> Sorted >> SetLike >> Subtractable >> Set >> GenSet >> GenericSetTemplate >> GenSetLike >> Iterable >> IterableLike >> GenIterableLike >> Equals >> GenIterable >> Traversable >> GenTraversable >> GenericTraversableTemplate >> TraversableLike >> Parallelizable >> GenTraversableLike >> TraversableOnce >> GenTraversableOnce >> FilterMonadic >> HasNewBuilder >> (A => Boolean) >> lin(AbstractSet)

trait BitSetLike[+This <: BitSetLike[This] with SortedSet[Int]] extends SortedSetLike[Int, This]
(BitSetLike >> SortedSetLike)

lin(BitSet) = BitSet >> Serializable >> java.io.Serializable >> BitSet >> BitSetLike >> SortedSet >> SortedSetLike >> Sorted >> SetLike >> Subtractable
>> Set >> GenSet >> GenericSetTemplate >> GenSetLike >> Iterable >> IterableLike >> GenIterableLike >> Equals >> GenIterable >> Traversable
>> GenTraversable >> GenericTraversableTemplate >> TraversableLike >> Parallelizable >> GenTraversableLike >> TraversableOnce
>> GenTraversableOnce >> FilterMonadic >> HasNewBuilder >> (A => Boolean) >> lin(AbstractSet)

   */


}
