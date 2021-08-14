package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeMirror {
    static boolean isSymmetric(TreeNode root){
        if (root == null){
            return true;
        }
        return dfs(root.left ,root.right); //比较左子树和右子树
    }
    static boolean dfs(TreeNode left, TreeNode right){
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val!= right.val){
            return false;
        }
        return dfs(left.left,right.right)&&dfs(left.right,right.left);
    }

    static boolean isSymmetricByBFS(TreeNode root){
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTreeNodes();
        boolean symmetric = TreeMirror.isSymmetricByBFS(treeNode);
        System.out.println("symmetric = " + symmetric);
    }
}
