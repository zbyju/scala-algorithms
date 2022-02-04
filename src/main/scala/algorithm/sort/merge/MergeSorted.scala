package algorithm.sort.merge

object MergeSorted {
    def merge(arr1: Seq[Int], arr2: Seq[Int]): Seq[Int] = {
        if(arr1.length == 0) return arr2
        if(arr2.length == 0) return arr1
        if(arr1.head < arr2.head) return arr1.head +: merge(arr1.drop(1), arr2)
        else return arr2.head +: merge(arr1, arr2.drop(1))
    }

    def merge(arrs: (Seq[Int], Seq[Int])): Seq[Int] = merge(arrs._1, arrs._2)
}