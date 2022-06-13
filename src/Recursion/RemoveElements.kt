package Recursion

import binarysearch.ListNode

fun main() {
    printListNode(RemoveElements().removeElements(generateInputList(), 2))
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
}