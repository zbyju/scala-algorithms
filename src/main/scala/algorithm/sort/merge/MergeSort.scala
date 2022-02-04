package algorithm.sort.merge

object MergeSort {
  def split(arr: Seq[Int]): (Seq[Int], Seq[Int]) = {
    (arr.dropRight(arr.length / 2), arr.drop((arr.length.toDouble / 2).ceil.toInt))
  }

  def sort(arr: Seq[Int]): Seq[Int] = {
    if(arr.length == 1 || arr.length == 0) return arr
    val splitArr = split(arr)
    MergeSorted.merge(MergeSort.sort(splitArr._1), MergeSort.sort(splitArr._2))
  }
}
