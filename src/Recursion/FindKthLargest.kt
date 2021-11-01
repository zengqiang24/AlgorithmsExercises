package Recursion

/**
 * 考察知识点：
 * 快速排序，
 * 递归，在拆分过程中解决问题
 *
 */
fun main() {
    val findKthLargest = FindKthLargest()
    val nums = intArrayOf(3, 2, 1, 5, 6, 4)
    val nums2 = intArrayOf(3,2,3,1,2,4,5,5,6)
    val nums3 = intArrayOf(2,1)
    val nums4 = intArrayOf(1,2,3,4,5,6)

    val k = 2
    val k2 = 4
    val k3 = 1
    val k4 = 2
    val result = findKthLargest.findKthLargest(nums4, k3)
    println("nums =  ${nums3.contentToString()}")
    println("result = $result")
}

class FindKthLargest {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        return sortAndFindK(0, nums.size - 1, nums, nums.size - k )
    }

    //3, 2, 1, 5, 6, 4
    //1,2,3,5,6,3

    //k = 2 第二大 也就是第5小， i = 4  size - 2
    //p=2,是第nums.size - p = 6 -2 =4 第四大。 1 2 3 4 5 6
    private fun sortAndFindK(left: Int, right: Int, nums: IntArray, k: Int): Int {
        val p = partition(left, right, nums)
        if(p == k) return nums[p]
        return if(p < k) sortAndFindK(p + 1, right, nums, k)  else sortAndFindK(left, p - 1, nums, k)
    }

    private fun partition(left: Int, right: Int, nums: IntArray): Int {
        var p = left
        var i = left
        var j = right + 1
        while (true) {
            while (nums[i++] < nums[p]) {
                if (i > right) break
            }

            while (nums[--j] > nums[p]) {
                if (j <= left) break
            }

            if (i >= j) break
            exch(i, j, nums)
        }
        exch(p, j, nums)
        return j
    }

    private fun exch(i: Int, j: Int, nums: IntArray) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}