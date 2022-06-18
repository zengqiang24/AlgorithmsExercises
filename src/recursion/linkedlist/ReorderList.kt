package recursion.linkedlist

import binarysearch.ListNode
import recursion.generateInputList3
import recursion.printListNode

/**
 * 重排链表
 */
fun main() {
    ReorderList().reorderList(generateInputList3())
}

class ReorderList {
    /**
     * THE STEPS OF ANALYSIS
     * 1. Get the second list by figure out the middle of input list.
     * 2. Reverse the second list.
     * 3. Merge l1 and l2 list.
     */
    fun reorderList(head: ListNode?): Unit {
        var l1 = head
        print("input : ")
        printListNode(l1)
        println()

        var mid = middle(head)
        println("mid = ${mid?.`val`}")
        var l2 = mid?.next
        mid?.next = null

        print("l1:")
        printListNode(l1)

        l2 = reverseNode(l2)
        println()
        print("l2:")
        printListNode(l2)


        mergeList(l1, l2)

        println()
        print("output = ")
        printListNode(l1)
    }

    /**
     * Get the second list by figure out the middle of input list.
     */
    private fun middle(head: ListNode?): ListNode? {
        //Define two pointer which are both point to head.
        var slow: ListNode? = head
        var fast: ListNode? = head

        while (slow?.next != null && fast?.next?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }
        return slow
    }

    /**
     * 2. Reverse the second list by recursive the linked list.
     */
    private fun reverseNode(head: ListNode?): ListNode? {
        while (head?.next == null) return head

        var res = reverseNode(head?.next)
        head?.next?.next = head
        head?.next = null
        return res
    }

    /**
     * 3. Merge l1 and l2 list.
     */
    private fun mergeList(list1: ListNode?, list2: ListNode?) {
        var l1 = list1
        var l2 = list2
        while (l1 != null && l2 != null) {
            var temp1 = l1.next
            var temp2 = l2.next

            l1?.next = l2
            l1 = temp1

            l2?.next = l1
            l2 = temp2
        }
    }
}