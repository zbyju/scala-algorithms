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

    al.insert(1)
    al.insert(2)
    al.insert(3)

    assertEquals(Seq(1, 2, 3), al.toSeq)
  }
}
