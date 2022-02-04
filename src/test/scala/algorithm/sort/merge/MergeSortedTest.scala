package algorithm.sort.merge

import org.junit.Test
import org.junit.Assert.*

class MergeSortedTest {
  @Test def sortEmpty() = {
      assertEquals(Seq(), MergeSorted.merge(Seq(), Seq()))
      assertEquals(Seq(1), MergeSorted.merge(Seq(1), Seq()))
      assertEquals(Seq(1), MergeSorted.merge(Seq(), Seq(1)))
      assertEquals(Seq(1, 2, 3), MergeSorted.merge(Seq(1, 2, 3), Seq()))
      assertEquals(Seq(1, 2, 3), MergeSorted.merge(Seq(), Seq(1, 2, 3)))
  }

  @Test def sortSameLength() = {
      assertEquals(Seq(1, 2, 3, 4), MergeSorted.merge(Seq(1, 2), Seq(3, 4)))
      assertEquals(Seq(1, 2, 3, 4), MergeSorted.merge(Seq(1, 3), Seq(2, 4)))
      assertEquals(Seq(1, 2, 3, 4), MergeSorted.merge(Seq(1, 4), Seq(2, 3)))
      assertEquals(Seq(1, 2, 3, 4), MergeSorted.merge(Seq(3, 4), Seq(1, 2)))
      assertEquals(Seq(1, 2, 3, 4), MergeSorted.merge(Seq(2, 4), Seq(1, 3)))
      assertEquals(Seq(1, 2, 3, 4, 5, 6), MergeSorted.merge(Seq(1, 3, 5), Seq(2, 4, 6)))
  }

  @Test def sortDiffLength() = {
      assertEquals(Seq(1, 2, 3, 4, 5), MergeSorted.merge(Seq(1, 2, 3), Seq(4, 5)))
      assertEquals(Seq(1, 2, 3, 4, 5), MergeSorted.merge(Seq(1, 3), Seq(2, 4, 5)))
      assertEquals(Seq(1, 2, 3, 4, 5), MergeSorted.merge(Seq(3, 4, 5), Seq(1, 2)))
      assertEquals(Seq(1, 2, 3, 4, 5), MergeSorted.merge(Seq(2, 4, 5), Seq(1, 3)))
      assertEquals(Seq(1, 2, 3), MergeSorted.merge(Seq(1, 3), Seq(2)))
  }

  @Test def sortDuplicateEntries() = {
      assertEquals(Seq(1, 1, 1, 1), MergeSorted.merge(Seq(1, 1), Seq(1, 1)))
      assertEquals(Seq(1, 1, 2, 2), MergeSorted.merge(Seq(1, 2), Seq(1, 2)))
      assertEquals(Seq(1, 2, 2, 2), MergeSorted.merge(Seq(1, 2), Seq(2, 2)))
      assertEquals(Seq(1, 2, 2, 3, 3, 4), MergeSorted.merge(Seq(2, 3, 4), Seq(1, 2, 3)))
  }
}
