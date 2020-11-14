/**
 * Created by qiangzeng on 17/6/5.
 */
public class BST<Key extends Comparable, Value> {
    private class Node {
        public int N;
        public Value value;
        public Key key;

        public Node left;
        public Node right;

        public Node(Key key, Value v, int n) {
            this.key = key;
            this.value = v;
            this.N = n;
        }

    }

    private Node root;


    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        if (x == null) return null;
        int i = key.compareTo(x.key);
        if (i < 0)
            return get(x.left, key);
        else if (i > 0) return get(x.right, key);
        else return x.value;

    }

    public Value findNoRecursor(Node currentNode, Key key) {
        if (currentNode == null) return null;
        int cmp;
        while ((cmp = key.compareTo(currentNode.key)) != 0) {
            if (cmp < 0) {
                currentNode = currentNode.left;
            } else if (cmp > 0) {
                currentNode = currentNode.right;
            }
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode.value;

    }

    public void insertNoRecursor(Node x, Key key, Value v) {
        if (x == null) root = new Node(key, v, 1);
        else {
            Node parent;
            Node current = x;
            while (true) {
                parent = x;
                if (x.key.compareTo(key) < 0) {
                    current = current.left;
                    if (current == null) parent.left = x;
                    return;
                } else if (x.key.compareTo(key) > 0) {
                    current = current.right;
                    if (current == null) parent.right = x;
                    return;
                }

            }
        }


    }

    public int size(Node n) {
        if (n == null) return 0;
        return n.N;
    }

    public Node put(Key key, Value value) {
        return put(root, key, value);

    }

    public Node put(Node x, Key key, Value value) {
        if (x == null) return x = new Node(key, value, 1);

        int i = key.compareTo(x.key);
        if (i < 0)
            x.left = put(x.left, key, value);
        else if (i > 0) x.right = put(x.right, key, value);
        else
            x.value = value;
        x.N = size(x.left) + size(x.right) + 1;
        return x;

    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.value);
            inOrder(node.right);
        }
    }


    //todo
    public boolean checkInOrder(Node node) {



        return true;
    }

    public Key min() {
        return min(root);
    }

    public Key min(Node n) {
        if (n.left == null) return n.key;
        return min(n.left);
    }

}
