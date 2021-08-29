package LinkNodeReview;

import binarysearch.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LinkListReview {
    static List<ListNode> tmp = new ArrayList<>();

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode newNode = getKthFromEnd(l1, 2);
        System.out.print("newNode" + newNode.val);
    }

    public static ListNode reverseByTraverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = null;
            tmp = cur.next;//暂存下一个节点，以待遍历
            cur.next = pre;

            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static int[] reversePrint(ListNode head) {
        recursion2(head, head);
        int[] result = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            result[i] = tmp.get(i).val;
        }
        return result;
    }

    public static void recur(ListNode node) {
        //递归的出口总是想不出来？
        if (node == null) {
            return;
        }
        recur(node.next);
        tmp.add(node);
    }

    public static ListNode recursion2(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        }
        ListNode res = recursion2(cur.next, cur);//递归
//        递归出来后，就不会继续走上一行代码了，也就是说res是固定的了，即反转链表的头节点4
        cur.next = pre;//
        return res;
    }


    public static ListNode copyList(ListNode head) {
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (cur != null) {
            ListNode node = new ListNode(cur.val);
            pre.next = node;//修改指针，即pre/dummy的next指针等于node指针， 指针的内容指向新的值。
            cur = cur.next;//修改cur指针，即cur等于cur.next，意味着下一轮将修改cur.next内容。
            pre = node; //修改pre指针，意味着下一轮将修改pre.next的内容。
        }

        return dummy.next;
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode cur = head;
        ListNode temp;
        ListNode pre = null;
        if (head == null) {
            return head;
        }
        while (k > 0 && cur != null) {
            temp = cur.next;//暂存下一个节点
            cur.next = pre;

            pre = cur;
            cur = temp;
            k--;
        }

        while (slow != null) {
            if (cur == null) {
                cur = pre;
            } else {
                temp = cur.next;
                cur.next = pre;

                pre = cur;
                cur = temp;
                continue;
            }
            if (slow.val == cur.val) {
                return slow;
            }
            cur = cur.next;
            slow = slow.next;
            if (cur != null){

            }

        }
        return slow;
    }
}
