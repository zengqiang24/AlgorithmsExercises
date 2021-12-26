package binarysearch;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    /**
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next= reverseList(l1);
        System.out.print(l1);

//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);
//
//        ListNode result = mergeTwoLists(l1, l2);


    }

    public static ListNode reverseList(ListNode head) {
        head.next = nextNode(head);
        return head;
    }

    public static ListNode nextNode(ListNode head) {
        if (head.next == null) {
            return null;
        }
        return nextNode(head.next);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while ((l1 != null || l2 != null)) {
            if (l1.val < l2.val) {
                cur = l1;
                l1 = l1.next;
            } else {
                cur = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}


