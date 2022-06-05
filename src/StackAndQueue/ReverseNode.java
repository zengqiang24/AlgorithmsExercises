package StackAndQueue;

import binarysearch.ListNode;

public class ReverseNode {

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ListNode dummy = new ListNode(0);
        dummy.next = node;
        while(node != null) {
//            System.out.print(" " + node.val);
            node = node.next;
        }


       ListNode newHead =  reverse(dummy.next,null);

        while(newHead != null) {
            System.out.print(" " + newHead.val);
            newHead = newHead.next;
        }
    }

    //0 - > 1 -> 2-->3 -->4

    //null
    //4 pre=3
    //3 pre=2
    //2  pre=1
    // 1 pre=0
    // 0 pre=null
    private static ListNode reverse(ListNode cur, ListNode pre) {
        if(cur == null) {
            return pre;
        }
        ListNode res =  reverse(cur.next, cur);// res 只会初始化一次，即递归到达base case的时候。
        cur.next = pre;
        return res;
    }


}
