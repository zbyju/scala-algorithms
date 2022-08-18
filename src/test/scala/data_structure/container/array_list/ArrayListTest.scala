package data_structure.container.array_list

import org.junit.Test
import org.junit.Assert.*
import data_structure.array_list.ArrayList

class ArrayListTest {
  @Test def constructor = {
    val al = ArrayList[Int]()
    assertEquals(0, al.length)
    assertEquals(true, al.isEmpty)
    assertEquals(Seq(), al.toSeq)
    assertEquals(None, al.delete())
    assertEquals(None, al.delete(0))
    assertEquals(None, al.delete(10))
    assertEquals(None, al.delete(-1))

    al.insert(1)
    al.insert(2)
    al.insert(3)

    assertEquals(Seq(1, 2, 3), al.toSeq)
    assertEquals(1, al(0))
    assertEquals(2, al(1))
    assertEquals(3, al(2))
    assertEquals(3, al(-1))
    assertEquals(2, al(-2))
    assertEquals(1, al(-3))
    assertEquals(1, al(3))

    al.insert(4)
    al.insert(5)
    al.insert(6)
    al.insert(7)
    al.insert(8)
    al.insert(9)
    al.insert(10)
    al.insert(11)

    assertEquals(Some(11), al.delete())
    assertEquals(Some(10), al.pop())
    assertEquals(Some(9), al.dequeue())

    al.deleteAll()

    al.insert(3)
    al.insert(1, 0)
    al.insert(2, 1)

    assertEquals(Some(2), al.delete(1))
    assertEquals(Some(3), al.delete(1))
    assertEquals(None, al.delete(1))
    assertEquals(Some(1), al.delete())

    al.insert(10, 100)
    assertEquals(Some(10), al.delete())
  }
}
