package data_structure.array_list

import scala.reflect.ClassTag
import scala.language.implicitConversions

class ArrayList[T: ClassTag] extends Iterator[T] {
  private var lengthVal = 0
  private val growConstant = 2
  private val initialCapacity = 10
  private var capacity = initialCapacity
  private var array = getInitialArray()
  private val test = List()

  private var idx = 0

  private def getInitialArray(): Array[T] = new Array[T](initialCapacity)

  override def size: Int = lengthVal
  override def hasNext: Boolean = idx < lengthVal

  override def next(): T = {
    val res = this.apply(idx)
    idx += 1
    res
  }

  // Array operations
  def apply(idx: Int): T = {
    if (idx < length && idx >= 0) {
      return array(idx)
    } else {
      return apply(Math.floorMod(idx, length))
    }
  }

  def insert(value: T, idx2: Int): Unit = {
    val idx = Math.min(idx2, length)
    if (length + 1 >= capacity) {
      capacity *= 2
      val biggerArray = new Array[T](capacity * growConstant)
      for (i <- 0 until length + 1) {
        if (i < idx) biggerArray(i) = array(i)
        else if (i == idx) biggerArray(i) = value
        else biggerArray(i) = array(i - 1)
      }
      array = biggerArray
    } else if (idx == length) {
      array(idx) = value
    } else {
      for (i <- idx + 1 until length + 1) {
        array(i) = array(i - 1)
      }
      array(idx) = value
    }
    lengthVal += 1
  }

  def insert(value: T): Unit = insert(value, length)

  def delete(idx: Int): Option[T] = {
    if (idx < 0 || idx >= length || length <= 0) return None

    var deleted: Option[T] = Some(array(idx))
    for (i <- idx until length) {
      array(i) = array(i + 1)
    }
    lengthVal -= 1
    deleted
  }

  def delete(): Option[T] = delete(length - 1)

  // Stack operations O(1)
  def push(value: T) = insert(value, length)

  def pop() = delete()

  // Queue operations O(n) enqueue; O(1) dequeue
  def enqueue(value: T) = insert(value, 0)

  def dequeue() = delete()

  // Misc
  def first = array(0)

  def last = array(lengthVal - 1)

  def deleteAll() = {
    lengthVal = 0
    capacity = initialCapacity
    array = getInitialArray()
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
