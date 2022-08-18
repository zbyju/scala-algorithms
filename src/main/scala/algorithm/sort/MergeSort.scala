package algorithm.sort.merge

object MergeSort {
  def split(arr: Seq[Int]): (Seq[Int], Seq[Int]) = {
    (
      arr.dropRight(arr.length / 2),
      arr.drop((arr.length.toDouble / 2).ceil.toInt)
    )
  }

  def mergeSorted(arr1: Seq[Int], arr2: Seq[Int]): Seq[Int] = {
    if (arr1.length == 0) return arr2
    if (arr2.length == 0) return arr1
    if (arr1.head < arr2.head)
      return arr1.head +: mergeSorted(arr1.drop(1), arr2)
    else return arr2.head +: mergeSorted(arr1, arr2.drop(1))
  }

  def mergeSorted(arrs: (Seq[Int], Seq[Int])): Seq[Int] =
    mergeSorted(arrs._1, arrs._2)

  def sort(arr: Seq[Int]): Seq[Int] = {
    if (arr.length == 1 || arr.length == 0) return arr
    val splitArr = split(arr)
    mergeSorted(sort(splitArr._1), sort(splitArr._2))
  }
}
