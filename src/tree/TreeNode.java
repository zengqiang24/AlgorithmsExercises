package tree;

public class TreeNode {
    public int val = 0;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }

   public static TreeNode createTreeNodes(){
        TreeNode treeNode = new TreeNode(8);
        TreeNode treeNode1 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(10);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(9);
        TreeNode treeNode6 = new TreeNode(11);
        TreeNode treeNode7 = new TreeNode(3);


       /**
        *       8
        *     6  10
        *    5 7 9 11
        *   3
        *
        */
       treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;


        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;



        treeNode3.left = treeNode7;
        return treeNode;
    }
}
