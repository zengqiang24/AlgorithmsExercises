package Recursion

/**
 *输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 *输出: 4
 */
class FindKthLargestViaHeapSort {

    //堆的性质：
    //对一个数组，构建它的最小堆，会有这样的特点：最顶的元素要小于其左右子树的元素。
    //转化问题：
    //搜索数组，构建一个最大长度为k的最小堆，返回最顶元素，即为第k大的元素。

    //数组怎么图像化成堆？
    fun heapify(heapArray: IntArray, newValue: Int){
        if(heapArray[0] > newValue) {

        }
    }
}