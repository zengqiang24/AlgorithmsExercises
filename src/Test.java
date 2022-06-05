public class Test {

    public static void main(String[] args) {
        //ListNode 删除链表的倒数第n个节点
        //删掉N个节点
        //初始化
        ListNode node5 = new ListNode(2, null);
        ListNode node4 = new ListNode(8, node5);
        ListNode node3 = new ListNode(6, node4);
        ListNode node2 = new ListNode(4, node3);
        ListNode head = new ListNode(0, node2);

        ListNode result = deleteNode(head, 5);
        if (result == null) {
            System.out.println("not found..");
        } else {
            while (result != null) {
                System.out.print(result.val + " ");
                result = result.next;
            }
        }
    }

    private static ListNode deleteNode(ListNode head, int N) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(0, null);
        dummyNode.next = head;
        ListNode fast = head;
        ListNode slow = head;
        //0,4,6,8,2
        //快指针先走N步
        int i = 0;
        for (; i < N; i++) {
            if (fast != null) {
                fast = fast.next;
            }
        }
        if (fast != null) {
            while (true) {
                fast = fast.next;
                if (fast == null) {
                    break;
                }
                slow = slow.next;
            }

            slow.next = slow.next.next;
        } else {
            if (i == N) {
                dummyNode.next = dummyNode.next.next;
                return dummyNode.next;
            }
            return null;
        }

        return dummyNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
