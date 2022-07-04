package leecode.sort

import java.util.*

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

 

示例 1：

输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
fun main() {
    //[[1,3],[2,6],[8,10],[15,18]]
    var interval = arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))
    val mergedList = Merge().mergeIntervals(interval)
    for (ints in mergedList) {
        println("[${ints[0]},${ints[1]}]")
    }
}

class Merge {
    /**
     **
    输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    输出：[[1,6],[8,10],[15,18]]
    解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     */
    fun mergeIntervals(interval: Array<IntArray>): Array<IntArray> {
        Arrays.sort(interval) { o1, o2 -> o1[0] - o2[0] }

        var merged = mutableListOf<IntArray>()
        var i = 0
        while (i < interval.size) {
            var temp = intArrayOf(interval[i][0], interval[i][1]) //current interval
            var j = i + 1
            while (j < interval.size && interval[j][0] <= temp[1]) {//if they are overlapping.
                temp[1] = temp[1].coerceAtLeast(interval[j][1]) //merge
                j++
            }
            merged.add(temp)
            i = j
        }
        return merged.toTypedArray()
    }

}