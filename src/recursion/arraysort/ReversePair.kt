package recursion.arraysort

/**
 * 求翻转对
 */
fun main() {
    ReversePair().reversePairs()
}

class ReversePair {
    fun reversePairs() {
        val nums = intArrayOf(2147483647,2147483647,-2147483647,-2147483647,-2147483647,2147483647)
        val aux = IntArray(nums.size)
        val count = mergeSort(nums, 0, nums.size - 1, aux)
        print("count = $count")
    }

    fun mergeSort(nums: IntArray, lo: Int, hi: Int, aux: IntArray): Int {
        if(lo == hi) {
            return 0
        }
        val mid = lo + (hi - lo) / 2
        val l = mergeSort(nums, lo, mid, aux)
        val r = mergeSort(nums, mid + 1, hi, aux)
        var ret = l + r

        //cal amount of reverse pair between left array and right array.
        var i = lo
        var j = mid + 1
        while (i <= mid) {
            //[2, 3, 8] [0, 1, 5]

            //move j to the left util meet nums[i] <= 2 * nums[j]
            while (j <= hi && nums[i].toLong() > 2 * (nums[j] .toLong())) {
                j++
            }
            // [2,0][2, 1] are reverse pair.
            ret += j - mid - 1

            i++ // continue to move point i to the right.
        }
        //merge those array
        merge(nums, lo, mid, hi, aux)
        return ret
    }

    private fun merge(nums: IntArray, lo: Int, mid: Int, hi: Int, aux: IntArray) {
        //copy to aux
        for (i in lo..hi) {
            aux[i] = nums[i]
        }

        //copy ordered aux to nums
        var k = lo
        var i = lo
        var j = mid + 1
        while (i <= mid && j <= hi) {
            if (aux[i] <= aux[j]) {
                nums[k] = aux[i]
                i++
                k++
            } else {
                nums[k] = aux[j]
                j++
                k++
            }
        }

        while (i <= mid) {
            nums[k] = aux[i]
            i++
            k++
        }

        while (j <= hi) {
            nums[k] = aux[j]
            j++
            k++
        }
    }
}