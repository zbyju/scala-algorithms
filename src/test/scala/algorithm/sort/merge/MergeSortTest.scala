package algorithm.sort.merge

import org.junit.Test
import org.junit.Assert.*

class MergeSortTest {
  @Test def sortEmptyMergeSorted() = {
    assertEquals(Seq(), MergeSort.mergeSorted(Seq(), Seq()))
    assertEquals(Seq(1), MergeSort.mergeSorted(Seq(1), Seq()))
    assertEquals(Seq(1), MergeSort.mergeSorted(Seq(), Seq(1)))
    assertEquals(Seq(1, 2, 3), MergeSort.mergeSorted(Seq(1, 2, 3), Seq()))
    assertEquals(Seq(1, 2, 3), MergeSort.mergeSorted(Seq(), Seq(1, 2, 3)))
  }

  @Test def sortSameLengthMergeSorted() = {
    assertEquals(Seq(1, 2, 3, 4), MergeSort.mergeSorted(Seq(1, 2), Seq(3, 4)))
    assertEquals(Seq(1, 2, 3, 4), MergeSort.mergeSorted(Seq(1, 3), Seq(2, 4)))
    assertEquals(Seq(1, 2, 3, 4), MergeSort.mergeSorted(Seq(1, 4), Seq(2, 3)))
    assertEquals(Seq(1, 2, 3, 4), MergeSort.mergeSorted(Seq(3, 4), Seq(1, 2)))
    assertEquals(Seq(1, 2, 3, 4), MergeSort.mergeSorted(Seq(2, 4), Seq(1, 3)))
    assertEquals(
      Seq(1, 2, 3, 4, 5, 6),
      MergeSort.mergeSorted(Seq(1, 3, 5), Seq(2, 4, 6))
    )
  }

  @Test def sortDiffLengthMergeSorted() = {
    assertEquals(
      Seq(1, 2, 3, 4, 5),
      MergeSort.mergeSorted(Seq(1, 2, 3), Seq(4, 5))
    )
    assertEquals(
      Seq(1, 2, 3, 4, 5),
      MergeSort.mergeSorted(Seq(1, 3), Seq(2, 4, 5))
    )
    assertEquals(
      Seq(1, 2, 3, 4, 5),
      MergeSort.mergeSorted(Seq(3, 4, 5), Seq(1, 2))
    )
    assertEquals(
      Seq(1, 2, 3, 4, 5),
      MergeSort.mergeSorted(Seq(2, 4, 5), Seq(1, 3))
    )
    assertEquals(Seq(1, 2, 3), MergeSort.mergeSorted(Seq(1, 3), Seq(2)))
  }

  @Test def sortDuplicateEntriesMergeSorted() = {
    assertEquals(Seq(1, 1, 1, 1), MergeSort.mergeSorted(Seq(1, 1), Seq(1, 1)))
    assertEquals(Seq(1, 1, 2, 2), MergeSort.mergeSorted(Seq(1, 2), Seq(1, 2)))
    assertEquals(Seq(1, 2, 2, 2), MergeSort.mergeSorted(Seq(1, 2), Seq(2, 2)))
    assertEquals(
      Seq(1, 2, 2, 3, 3, 4),
      MergeSort.mergeSorted(Seq(2, 3, 4), Seq(1, 2, 3))
    )
  }

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
    assertEquals(Seq(1, 2, 3), MergeSort.sort(Seq(2, 1, 3)))
    assertEquals(Seq(1, 2, 3), MergeSort.sort(Seq(3, 1, 2)))
    assertEquals(Seq(10, 50, 100), MergeSort.sort(Seq(100, 50, 10)))
    assertEquals(Seq(10, 50, 100), MergeSort.sort(Seq(50, 10, 100)))
    assertEquals(Seq(10, 50, 100), MergeSort.sort(Seq(50, 100, 10)))
    assertEquals(Seq(-5, -1, 0, 1, 5), MergeSort.sort(Seq(5, -1, 0, 1, -5)))
    assertEquals(Seq(-5, -1, 0, 1, 5), MergeSort.sort(Seq(5, 1, 0, -1, -5)))
    assertEquals(Seq(-5, -1, 0, 1, 5), MergeSort.sort(Seq(-1, -5, 0, 5, 1)))
    assertEquals(Seq(-5, -1, 0, 1, 5), MergeSort.sort(Seq(0, 1, -1, -5, 5)))
  }
}
