package leecode.tree

import tree.TreeNode
//利用后序遍历，递归解决二叉树剪枝。
class PruneTree {
    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     */
    fun pruneTree(root: TreeNode?): TreeNode? {
        if (root == null) { // 定义终止条件，叶节点时退递归
            return root
        }
        //明确调用单元： 左子树为空，右子树为空，当前为0，则剪枝。
        root?.left = pruneTree(root.left)
        root?.right = pruneTree(root.right)
        return if (root?.`val` == 0 && root?.left == null && root?.right == null) {
            null
        } else {
            root  //返回剪辑后的节点
        }
    }
}