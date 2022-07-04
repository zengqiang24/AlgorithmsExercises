package recursion.arraysort

import recursion.generateInputList
import recursion.generateInputList2
import recursion.printListNode
import binarysearch.ListNode

/**合并两个已排序的链表
 *  输入：l1 = [1,2,4], l2 = [1,3,4]
 *  输出：[1,1,2,3,4,4]
 */
fun main() {
    val list1 = generateInputList()
    var list2 = generateInputList2()
    val mergedSortedList = MergeSortedLists().mergeTwoLists(list1, list2)

    printListNode(mergedSortedList)
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

    /**
     * 利用迭代，合并两个链表。
     */
    fun mergeTwoListsByIterate(head1: ListNode?, head2: ListNode?): ListNode? {
        var dummy = ListNode(0)
        var l1 = head1
        var l2 = head2
        var cur = dummy
        while(l1 != null && l2 != null) {
            if(l1.`val` <= l2.`val`) {
                cur.next = l1
                l1 = l1.next
            } else {
                cur.next = l2
                l2 = l2.next
            }
            cur = cur.next
        }
        if(l1 == null) cur?.next = l2
        if(l2 == null) cur?.next = l1
        return dummy.next
    }
}
