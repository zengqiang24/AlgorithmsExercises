package leecode.tree

import tree.TreeNode

/**
 *  求从根节点到叶子节点的路径数字之和
 */
class SumNumber {
    fun sumNumber(root: TreeNode): Int {
        return dfs(root, 0)
    }

    fun dfs(root: TreeNode, preSum: Int): Int {
        if(root == null) {
            return 0
        }

        var path = preSum * 10 + root.`val`
        if(root.left == null && root.right == null) {
            return path
        }
        return dfs(root.left, path) + dfs(root.right, path)
    }
}