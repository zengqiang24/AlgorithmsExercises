package recursion

/**
 * 求逆序对
 */
fun main() {
    var nums = intArrayOf(7, 5, 6, 4)
    val count = reversePairs(nums)
    println("final count = $count")
}

/**
 * 题目
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 输入数组 arr = [7，5，6，4]
 * 输出：5
 */
    fun reversePairs(nums: IntArray): Int {
        if(nums.size < 2) {
            return 0
        }
        val copy = IntArray(nums.size)
        for(i in nums.indices) {
            copy[i] = nums[i]
        }
        val aux = IntArray(nums.size)
        return findReversePair(copy, 0, nums.size - 1, aux)
    }
    fun findReversePair(nums: IntArray, lo: Int, hi: Int, aux: IntArray): Int{
        if (lo  == hi) {
            return 0
        }
        var mid =  lo + (hi - lo) / 2
        val leftReversePairsCount = findReversePair(nums, lo, mid, aux)
        val rightReversePairsCount = findReversePair(nums, mid + 1, hi, aux)
        if(nums[mid] < nums[mid + 1]) {
            return leftReversePairsCount + rightReversePairsCount
        }
        val crossPairsCount = mergeAndCount(nums, lo, mid, hi, aux)
        return leftReversePairsCount + rightReversePairsCount + crossPairsCount
    }

    fun mergeAndCount(nums: IntArray, lo: Int, mid: Int, hi:Int, aux:IntArray): Int{
        var count = 0
        //copy to aux
        for(i in lo..hi){
            aux[i] = nums[i]
        }

        var k = lo
        var i = lo
        var j = mid + 1

        while(k <= hi) {
            if(i > mid) {
                nums[k] = aux[j]
                j++
            } else if (j > hi) {
                nums[k] = aux[i]
                i++
            } else if(aux[i] <= aux[j]) {
                nums[k] = aux[i]
                i++
            } else if(aux[j] <= aux[i]) {
                nums[k] = aux[j]
                count += (mid - i + 1)
                j++
            }
            k++
        }
        return count
    }

