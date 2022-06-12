package Recursion

import binarysearch.ListNode

/**
 *  输入：l1 = [1,2,4], l2 = [1,3,4]
 *  输出：[1,1,2,3,4,4]
 */
fun main() {
    val list1 = generateList1()
    var list2 = generateList2()
    val mergedSortedList = MergeSortedLists().mergeTwoLists(list1, list2)

    printListNode(mergedSortedList)
}

fun generateList2(): ListNode? {
    var list = ListNode(1)
    var node2 = ListNode(3)
    var node3 = ListNode(4)
    list.next = node2
    node2.next = node3
    return list
}

private fun generateList1(): ListNode {
    var list1 = ListNode(1)
    var node2 = ListNode(2)
    var node3 = ListNode(4)
    list1.next = node2
    node2.next = node3
    return list1
}

class MergeSortedLists {
    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     */
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var l1 = list1
        var l2 = list2
        return if (l1 == null) { //meet bound condition, then return not null list2, which will concat the merged list.
            return l2
        } else if (l2 == null) {
            return l1
        } else if (l1.`val` < l2.`val`) {
            l1.next = mergeTwoLists(l1.next, l2) // if l1.val < l2.val, then merge current list1 and the recursion result of merge(list1.next, l2)
            l1
        } else {
            l2.next = mergeTwoLists(l1, l2.next)
            l2
        }
    }
}
