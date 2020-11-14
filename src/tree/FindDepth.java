package tree;

public class FindDepth {
    public int treeDepth(TreeNode root){
      if (root == null){
          return 0;
      }
      int leftDepth = treeDepth(root.left);
      int rightDepth = treeDepth(root.right);
        return Math.max(leftDepth,rightDepth) + 1;
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

        FindDepth findDepth = new FindDepth();
        System.out.println("depth = " + findDepth.treeDepth(treeNode));
     }
}
