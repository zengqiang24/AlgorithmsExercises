package tree;

import java.util.*;

public class TreeReview {
    public static void main(String[] args) {

        /**
         *       8
         *     6  10
         *    5 7 9 11
         *   3
         *
         */
        TreeNode treeNode = TreeNode.createTreeNodes();
        TreeNode node = mirrorTree(treeNode);
        System.out.print(node);
    }
      //8

    //10 6

    //5 7 9 11
//


    public static int[] levelOrder(TreeNode root) {
        if (root == null) {
            int[] r = new int[0];
            return r;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        queue.add(root);
        result.add(root.val);
        while (!queue.isEmpty()) {
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
        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;
    }

    public static List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> currentLevel = new LinkedList<>();
        List<Integer> levelResult = new ArrayList<>();
        currentLevel.add(root);
        int nextLevelSum = 1;
        /**
         *       8
         *     6  10
         *    5 7 9 11
         *   3
         *
         */
        LinkedList<TreeNode> nextLevel = new LinkedList<>();
        while (!currentLevel.isEmpty()) {
            boolean isOdd = (nextLevelSum)% 2 != 0;
            TreeNode node = null;
            if (isOdd) {
                node = currentLevel.removeFirst();
            } else {
                node = currentLevel.removeLast();
            }
             //8  nextSum=1 /nextLevel =(10,6 nextSum=1
            //6 nextSum 2/  nextLevel(
            if (!isOdd){
                levelResult.add(node.val);
            }else {
                levelResult.add(0,node.val);
            }

            if (!isOdd) { //如下一层是偶数层，从左到右插入队列
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
            } else { //如果是奇数层，从右到到插入队列
                if (node.right != null) {
                    nextLevel.add(node.right);//a:8, b:10 6     nextLevel:10 ,6; poll->10
                }
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
            }

            if (currentLevel.isEmpty()) {
                result.add(levelResult);
                nextLevelSum++;
                currentLevel = nextLevel;
                levelResult = new ArrayList<>();
                nextLevel = new LinkedList<>();
            }
        }
        return result;
    }

    public static TreeNode mirrorTree(TreeNode root) {
        mirrorSubTree(root);
        return root;
    }

    public static void mirrorSubTree(TreeNode root) {
        if(root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorSubTree(root.left);
        mirrorSubTree(root.right);
    }
}
