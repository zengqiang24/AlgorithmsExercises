package Recursion

import binarysearch.ListNode

fun main() {
    printListNode(RemoveElements().removeElements3(generateInputList(), 2))
}

class RemoveElements {

    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val dummyNode = ListNode(-1) // 定义哑节点，用于处理边界问题。
        dummyNode.next  = head
        var tempNode = dummyNode //当前节点指向哑节点
        while(tempNode?.next != null){ //如果当前下一个节点不为空
            if(tempNode?.next.`val` == `val`) { //判断当前节点值是不是等于要求移除的值
                tempNode?.next = tempNode?.next?.next //重点。移除节点的下一个元素。并且指针指向最新的删除后的链表值
            } else {
                tempNode = tempNode?.next //如果没有找到相等的值，则检查链表下一项。
            }
        }
        return dummyNode.next //返回哑节点第二个元素。
    }

    /**
     * 递归删除链表节点
     *
     * 对于给定的链表，首先对除了head以外的节点进行删除操作，然后判断head的节点值是否等于给定值val。
     * 如果head等于val，则删除head节点，返回head.next, 否则，删除操作后的头节点还是head，于是返回head节点。
     * 上述过程是一个递归过程
     * 边界条件是head 等于 空。
     */
    fun removeElementsByRecursive(head: ListNode?, `val`: Int): ListNode? {
        if(head == null) return head
        head?.next = removeElementsByRecursive(head?.next, `val`)
        return if (head ?.`val` == `val`) {
            head?.next
        } else {
          head
        }
    }

    fun removeElements3(head: ListNode?, `val`: Int): ListNode? {
        if(head == null) return head
        head?.next = removeElements3(head?.next, `val`)
        return if(head ?.`val` == `val`) {
            println("head?.val = ${head?.`val`}")
             head?.next // 返回给上一帧链接， 即pre.next = head.next
        } else {
             head
        }
    }
}