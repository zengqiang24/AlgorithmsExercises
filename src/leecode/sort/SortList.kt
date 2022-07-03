package leecode.sort

import binarysearch.ListNode
import recursion.*

fun main() {
//    var head1 = SortList().split(head)
    var node = SortList().sortList(generateInputList4())
    printListNode(node)
}

class SortList {
    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        var head1 = head
        var head2 = split(head1)
        head1 = sortList(head1)
        head2 = sortList(head2)
        return merge(head1, head2)
    }

    /**
     * 1 3 4 5
     *找到链表的中间节点
     */
    fun split(head: ListNode?): ListNode? {
        var slow = head
        var fast = head?.next
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next.next
        }
        var second = slow?.next
        slow?.next = null
        return second
    }

    /**
     * 合并两个链表
     *1,3
     *4,5
     */
    fun merge(node1: ListNode?, node2: ListNode?): ListNode? {
        var dummyNode = ListNode(0)

        var head1 = node1
        var head2 = node2
        var cur = dummyNode
        while (head1 != null && head2 != null) {
            if (head1.`val` < head2.`val`) {
                cur.next = head1
                head1 = head1.next
            } else {
                cur.next = head2
                head2 = head2.next
            }
            cur = cur.next
        }

        if (head2 != null) {
            cur.next = head2
        }
        if (head1 != null) {
            cur.next = head1
        }
        return dummyNode.next
    }
}