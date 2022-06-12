package Recursion

import binarysearch.ListNode

/**
 * Print the input ListNode to the console.
 */
fun printListNode(list: ListNode?) {
    var cur = list
    while (cur != null) {
        print(" " + cur.`val`)
        cur = cur.next
    }
}

fun generateInputList2(): ListNode? {
    var list = ListNode(1)
    var node2 = ListNode(3)
    var node3 = ListNode(4)
    list.next = node2
    node2.next = node3
    return list
}

fun generateInputList(): ListNode {
    var list1 = ListNode(1)
    var node2 = ListNode(2)
    var node3 = ListNode(4)
    list1.next = node2
    node2.next = node3
    return list1
}