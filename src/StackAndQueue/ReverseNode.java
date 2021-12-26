package StackAndQueue;

import binarysearch.ListNode;

public class ReverseNode {

    public ListNode reverseList(ListNode head) {
        head.next =  nextNode(head);
        return head;
    }
    public ListNode nextNode(ListNode head) {
        if(head.next == null) {
            return null;
        }
        return nextNode(head.next);
    }
}
