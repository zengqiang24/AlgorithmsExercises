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