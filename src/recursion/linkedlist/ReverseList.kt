package recursion.linkedlist

import recursion.generateInputList
import recursion.printListNode
import binarysearch.ListNode


/**
 * 求翻转链表
 */
fun main() {
 var list = generateInputList()
    println("input:")
    printListNode(list)
    println()
    println("output:")
    printListNode(ReverseList().reverseList(list))
}

class ReverseList {
    fun reverseList(head: ListNode?): ListNode? {
        if(head?.next == null) {
            return head
        }

        var res = reverseList(head?.next) //recursive next node
        head?.next?.next = head // reverse node from the end of list
        head?.next = null //cut off the head next point, prevent the cycle list issue.
        return  res
    }

    fun reverseListByIterate(head: ListNode?): ListNode? {
        var pre: ListNode? = null // cur need to pointer to previous node, so we define a previous node here.
        var cur = head
        while(cur != null) {
            var tmp = cur?.next //cache next node in order to move forward cur pointer.

            cur?.next = pre //reverse cur and pre pointer.
            pre = cur
            cur = tmp
        }
        return pre
    }

}