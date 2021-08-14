package tree;

import java.util.*;

public class TreeTraveral {
    //递归
    static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static void preOrderIterateTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();//每遇到一个节点，它本身一定是个根节点，故我们直接访问它。
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

    }

    static void midOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        midOrderTraversal(root.left);
        System.out.println(root.val);
        midOrderTraversal(root.right);
    }

    static void afterOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        afterOrderTraversal(root.left);
        afterOrderTraversal(root.right);
        System.out.println(root.val);
    }
    //深度优先遍历 队列遍历
    static void dfsLevelTraversalByQueue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()){
             TreeNode treeNode = queue.poll();
             System.out.println(" " + treeNode.val);
             if (treeNode.left!=null){
                 queue.add(treeNode.left);
             }
             if (treeNode.right!=null) {
                 queue.add(treeNode.right);
             }
        }
    }
    //深度优先遍历，层次遍历，用递归的办法
    static  List<List<Integer>>  dfsLevelTraversalByRecuise(TreeNode root) {
        List<List<Integer>> result  = new ArrayList<>();
        if (root == null){
            return result;
        }
        TreeNode cur = root;
        dfs(result,cur,0);
        return result;
    }
    private static  void dfs( List<List<Integer>>  res, TreeNode root, int level){
        if (root != null){
            if (res.size()-1<level){
                res.add(new ArrayList<>());
            }
            res.get(level).add(root.val);
            if (root.left!=null)
            dfs(res,root.left,level+1);
            if (root.right!=null)
            dfs(res,root.right,level+1);
        }
    }

    static void bfsLevelTraversalByQueue(TreeNode node){

    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTreeNodes();
        List<List<Integer>> lists = TreeTraveral.dfsLevelTraversalByRecuise(treeNode);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(" "  +integer);
            }


        }


    }
}
