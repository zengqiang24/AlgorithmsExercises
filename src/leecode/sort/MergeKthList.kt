package leecode.sort

import binarysearch.ListNode

/**
 *  合并k个链表。
 */
class MergeKthList {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if(lists?.size == 0){
            return null
        }
        return mergeKLists(lists, 0, lists.size)
    }

    fun mergeKLists(lists: Array<ListNode?>,start: Int, end: Int): ListNode? {
        if(start + 1 == end) {
            return lists[start]
        }
        var mid = start + (end - start) / 2
        var head1 = mergeKLists(lists, start, mid)
        var head2 = mergeKLists(lists, mid, end)
        return merge(head1, head2)
    }

    fun merge(head1: ListNode?, head2: ListNode?): ListNode? {
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
        if(l1 == null) cur?.next = l2 else cur?.next = l1
        return dummy.next
    }
}