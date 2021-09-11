import edu.princeton.cs.algs4.In;
import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LRCCacheByHand {
    Map<Integer, LinkedNode> hashMap = new HashMap<>();
    LinkedNode head, tail;
    private int capacity;
    private int size;

    public LRCCacheByHand(int capacity) {
        this.capacity = capacity;
        head =  new LinkedNode();
        tail =  new LinkedNode();
    }

    public void put(int key, int value) {
        LinkedNode linkedNode1 = hashMap.get(key);
        if (linkedNode1 == null) {
            linkedNode1 = new LinkedNode(key, value);
            hashMap.put(key, linkedNode1);
            addToHead(linkedNode1);
            ++size;
            if (size > capacity) {
                LinkedNode treeNode = removeTail();
                hashMap.remove(treeNode.key);
                --size;
            }
        } else {
            linkedNode1.val = value;//update its value if map contained it.
           moveToHead(linkedNode1);
        }
    }

    private LinkedNode removeTail() {
        LinkedNode before = tail.before;
        removeNode(before);
        return before;
    }

    public int get(int key) {
        LinkedNode e = hashMap.get(key);
        if (e == null) return -1;
        moveToHead(e);
        return e.val;
    }

    void removeNode(LinkedNode node) {
        LinkedNode b = node.before;
        LinkedNode a = node.after;
        b.after = a;
        a.before = b;
    }

    private void moveToHead(LinkedNode node) {
        //先断开当前节点
        removeNode(node);
        //更新dummy head指向的节点
        addToHead(node);
    }

    private void addToHead(LinkedNode node) {
        node.before = head;//等号左边相当于弧尾，从左到右， 从外到里的链接节点。
        node.after = head.after;
        //head<-node -> head.after
        //  head <-head.after
        //  head.after = node;
        head.after.before= node;
        head.after = node;
    }

    class LinkedNode {
        LinkedNode before, after;
        int val;
        int key;
        public LinkedNode() {
        }
        public LinkedNode(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }
}
