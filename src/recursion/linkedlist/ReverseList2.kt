package recursion.linkedlist

import binarysearch.ListNode
import recursion.generateInputList3
import recursion.printListNode

fun main() {
    print("input: ")
    printListNode(generateInputList3())
    println()
    
    var listNode = ReverseList2().reverseBetween(generateInputList3(), 1, 2)
    print("output: ")
    printListNode(listNode)
}

/**
 *  反转转部分区间的列表
 */
class ReverseList2 {
    var successor: ListNode? = null

    fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
        if (m == 1) {
            return reverseN(head, n)
        }
        head?.next = reverseBetween(head?.next, m - 1, n - 1)
        return head
    }

    private fun reverseN(head: ListNode?, n: Int): ListNode? {
        if (n == 1) {
            successor = head?.next
            return head
        }
        var last = reverseN(head?.next, n - 1)
        head?.next?.next = head
        head?.next = successor
        return last
    }
}