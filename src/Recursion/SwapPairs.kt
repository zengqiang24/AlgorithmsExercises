package Recursion

import binarysearch.ListNode

fun main() {
   val node = SwapPairs().swapPairs(generateInputList3())
    printListNode(node)
}
class SwapPairs {
    fun swapPairs(head: ListNode?): ListNode? {
        if(head?.next == null) return head
        var newHead = head.next
        head.next = swapPairs(newHead.next)
        newHead.next = head
        return newHead
    }
}