package recursion.linkedlist

import recursion.generateInputList3
import recursion.printListNode
import binarysearch.ListNode

fun main() {
   val node = SwapPairs().swapPairsByIterate(generateInputList3())
    printListNode(node)
}
class SwapPairs {

    /**
     * This is recursive method to swap pair between a linked list.
     */
    fun swapPairs(head: ListNode?): ListNode? {
        if(head?.next == null) return head
        var next = head?.next
        //交换head 和 next
        head?.next = swapPairs(next.next)  //head连接后面交换的子链表
        next?.next = head //next连接head，完成交换。
        return next // 返回交换后的链表
    }

    /**
     * This is iterate method to swap pair between a linked list.
     */
    fun swapPairsByIterate(head: ListNode?): ListNode? {
        val dummyNode = ListNode(0)
        dummyNode.next = head
        var temp = dummyNode
        while(temp?.next != null && temp?.next?.next != null) {
            var node1 = temp?.next
            var node2 = temp?.next?.next
            //BEFORE: temp->node1->node2
            temp?.next = node2
            node1.next = node2?.next
            node2?.next = node1

            //AFTER: temp -> node2 -> node1
            temp = node1
        }
        return dummyNode.next
    }
}