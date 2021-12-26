package tree;

import edu.princeton.cs.algs4.In;

import java.util.*;

public class TreeTraveral2 {
    /**
     * 8
     * 6  10
     * 5 7 9 11
     * 3
     * <p>
     * result: [8, 6, 5, 3, 7, 10, 9, 11]
     */
    private static List<Integer> preOrderTraveral(TreeNode node) {
        ArrayList result = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        if (node == null) {
            return result;
        }
        stack.push(node);
        while (stack.size() > 0 && (node = stack.pop()) != null) {
            result.add(node.val); //每遇到一个节点，它本身一定是个根节点，故我们直接访问它。
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    /**
     * 8
     * 6  10
     * 5 7 9 11
     * 3
     */
    private static void preOrderRecurse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(" " + root.val);
        preOrderRecurse(root.left);
        preOrderRecurse(root.right);
    }

    /**
     * 8
     * 6  10
     * 5 7 9 11
     * 3
     * result: 3 5 6 7 8 9 10 11
     */
    private static List<Integer> midOrderTraverse(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            while (node != null) {//先遍历根，和其左子树
                stack.push(node);
                node = node.left;
            }
            node = stack.pop(); //出栈左子树和根
            results.add(node.val);
            node = node.right;//最后遍历右子树?

        }
        return results;
    }

    private static void midOrderTraverseRecurse(TreeNode root) {
        if (root == null) {
            return;
        }
        midOrderTraverseRecurse(root.left);
        System.out.print(" " + root.val);
        midOrderTraverseRecurse(root.right);
    }

    /**
     * 8
     * 6  10
     * 5 7 9 11
     * 3
     * <p>
     * result:  3 5 7 6 9 11 10 8
     */
    private static void postOrderTraverseRecurse(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraverseRecurse(root.left);
        postOrderTraverseRecurse(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 8
     * 6  10
     * 5 7 9 11
     * 3
     * result: 3 5 7 6 9 11 10 8
     * 后序遍历： 遍历顺序是 所有左子树 - 所有右子树 - 根节点
     * 我们可以先求后序遍历的逆序（根节点->所有右子树->所有左子树，把逆序的结果反转过来就是正确答案）；
     */
    private static List<Integer> postOrderTraverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        TreeNode node = root;
        stack.push(node);
        while (!stack.empty()) {
            TreeNode n = stack.pop();
            result.add(0, n.val);
            if (n.left != null) {
                stack.push(n.left);
            }
            if (n.right != null) {
                stack.push(n.right);
            }
        }
        return result;
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     * /**
     * * 8
     * * 6  10
     * * 5 7 9 11
     * * 3
     */
    public static int[] levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            int[] o = new int[result.size()];
            for (int i = 0; i < o.length; i++) {
                o[i] = result.get(i);
            }
            return o;
        }
        result.add(root.val);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                result.add(node.left.val);
                queue.add(node.left);
            }
            if (node.right != null) {
                result.add(node.right.val);
                queue.add(node.right);
            }
        }
        int[] o = new int[result.size()];
        for (int i = 0; i < o.length; i++) {
            o[i] = result.get(i);
        }
        return o;
    }

    //    剑指 Offer 32 - III. 从上到下打印二叉树 III
//    请实现一个函数按照之字形顺序打印二叉树，
//    即第一行按照从左到右的顺序打印，
//    第二层按照从右到左的顺序打印，
//    第三行再按照从左到右的顺序打印，其他行以此类推。
//                 * * 8
//               * * 6  10
//           * *    5 7 9 11
//             * * 3
    public static List<List<Integer>> levelOrderZ(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() != 0) {
            int n = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (result.size() % 2 == 0) {
                    level.addFirst(node.val);
                } else {
                    level.addLast(node.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTreeNodes();

        //  List<Integer> integers =  preOrderTraveral(treeNode); //[8, 6, 5, 3, 7, 10, 9, 11]
//        preOrderRecurse(treeNode);

//        midOrderTraverseRecurse(treeNode); // 3 5 6 7 8 9 10 11
//        List<Integer> integers = midOrderTraverse(treeNode);
//        System.out.println(integers);

//        postOrderTraverseRecurse(treeNode); //3 5 7 6 9 11 10 8
//        List<Integer> integers = postOrderTraverse(treeNode); ////3 5 7 6 9 11 10 8
//        System.out.println(integers);

        List<List<Integer>> lists = levelOrderZ(treeNode);
        System.out.println(Arrays.toString(lists.toArray()));


    }

}
