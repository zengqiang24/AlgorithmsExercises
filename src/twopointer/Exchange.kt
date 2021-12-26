package twopointer

import java.util.*

class Exchange {
    fun exchange(nums: IntArray): IntArray {
        var lo = -1
        var hi = nums.size
        while (lo < hi) {

            while (++lo < nums.size && nums[lo] % 2 != 0) {
            }
            while (--hi > 0 && nums[hi] % 2 == 0) {
            }
            if (lo > hi) {
                break
            }
            swap(nums, lo, hi)
        }
        return nums
    }

    fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }


}
fun main() = run {
    var intArray = IntArray(7) { it + 1 }
    var nums = Exchange().exchange(intArray)
    System.out.println(Arrays.toString(nums))
}