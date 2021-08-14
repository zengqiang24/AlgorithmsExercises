package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class FindDepth2 {
    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int findDepthByBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        int answer = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) { //遍历当前层 所有节点。
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
//            遍历完一层，深度加1
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8);
        TreeNode treeNode1 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(10);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(9);
        TreeNode treeNode6 = new TreeNode(11);
        TreeNode treeNode7 = new TreeNode(3);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;


        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;

        treeNode5.left = treeNode7;

        FindDepth2 findDepth = new FindDepth2();
        System.out.println("depth = " + findDepth.treeDepth(treeNode));

        int maxPath = TreeKt.findMaxPath(treeNode);
        System.out.println("depth = " + maxPath);
    }

}
