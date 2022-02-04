package algorithm.sort.merge

import org.junit.Test
import org.junit.Assert.*

class MergeSortTest {
  @Test def splitEmpty = {
      assertEquals((Seq(), Seq()), MergeSort.split(Seq()))
      assertEquals((Seq(1), Seq()), MergeSort.split(Seq(1)))
  }

  @Test def splitEvenLength = {
      assertEquals((Seq(1), Seq(2)), MergeSort.split(Seq(1, 2)))
      assertEquals((Seq(1, 2), Seq(3, 4)), MergeSort.split(Seq(1, 2, 3, 4)))
  }

  @Test def splitOddLength = {
      assertEquals((Seq(1, 2), Seq(3)), MergeSort.split(Seq(1, 2, 3)))
      assertEquals((Seq(1, 2, 3), Seq(4, 5)), MergeSort.split(Seq(1, 2, 3, 4, 5)))
  }

  @Test def sortEmpty = {
    assertEquals(Seq(), MergeSort.sort(Seq()))
    assertEquals(Seq(1), MergeSort.sort(Seq(1)))
  }

  @Test def sortSorted = {
    assertEquals(Seq(1, 2), MergeSort.sort(Seq(1, 2)))
    assertEquals(Seq(1, 2, 3), MergeSort.sort(Seq(1, 2, 3)))
    assertEquals(Seq(10, 50, 100), MergeSort.sort(Seq(10, 50, 100)))
    assertEquals(Seq(-5, -1, 0, 1, 5), MergeSort.sort(Seq(-5, -1, 0, 1, 5)))
  }

  @Test def sort = {
    assertEquals(Seq(1, 2), MergeSort.sort(Seq(2, 1)))
    assertEquals(Seq(1, 2, 3), MergeSort.sort(Seq(3, 2, 1)))
    // assertEquals(Seq(1, 2, 3), MergeSort.sort(Seq(2, 1, 3)))
    // assertEquals(Seq(1, 2, 3), MergeSort.sort(Seq(3, 1, 2)))
    // assertEquals(Seq(10, 50, 100), MergeSort.sort(Seq(100, 50, 10)))
    // assertEquals(Seq(10, 50, 100), MergeSort.sort(Seq(50, 10, 100)))
    // assertEquals(Seq(10, 50, 100), MergeSort.sort(Seq(50, 100, 10)))
    // assertEquals(Seq(-5, -1, 0, 1, 5), MergeSort.sort(Seq(5, -1, 0, 1, -5)))
    // assertEquals(Seq(-5, -1, 0, 1, 5), MergeSort.sort(Seq(5, 1, 0, -1, -5)))
    // assertEquals(Seq(-5, -1, 0, 1, 5), MergeSort.sort(Seq(-1, -5, 0, 5, 1)))
    // assertEquals(Seq(-5, -1, 0, 1, 5), MergeSort.sort(Seq(0, 1, -1, -5, 5)))
  }
}
