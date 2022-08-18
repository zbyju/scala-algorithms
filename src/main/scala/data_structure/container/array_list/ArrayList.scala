package data_structure.array_list

import scala.reflect.ClassTag
import scala.language.implicitConversions

class ArrayList[T: ClassTag] extends Iterator[T] {
  private var lengthVal = 0
  private val growConstant = 2
  private val initialCapacity = 10
  private var capacity = initialCapacity
  private var array = new Array[T](initialCapacity)
  private val test = List()

  private var idx = 0

  override def size: Int = lengthVal
  override def hasNext: Boolean = idx < lengthVal

  override def next(): T = {
    val res = this.apply(idx)
    idx += 1
    res
  }

  def insert(value: T): Unit = {
    if (length + 1 >= capacity) {
      capacity *= 2
      val biggerArray = new Array[T](capacity * growConstant)
      for (i <- 0 until length) {
        biggerArray(i) = array(i)
      }
      array = biggerArray
    }
    array(length) = value
    lengthVal += 1
  }

  def first = array(0)

  def last = array(lengthVal - 1)

  def apply(idx: Int): T = {
    if (idx < length) {
      array(idx)
    } else {
      last
    }
  }

  override def toString(): String = {
    array.take(length).mkString("[", ", ", "]")
  }
}

object ArrayList {
  implicit def arrayListToSeq[T: ClassTag](al: ArrayList[T]): Seq[T] = {
    al.toSeq
  }
  implicit def seqToArrayList[T: ClassTag](s: Seq[T]): ArrayList[T] = {
    if (s.isEmpty) new ArrayList[T]()
    val al: ArrayList[T] = new ArrayList()
    s.foreach(x => al.insert(x))
    al
  }
}
