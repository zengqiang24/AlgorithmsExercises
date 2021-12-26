package tree

fun findMaxPath(treeNode: TreeNode?): Int {
    if (treeNode == null) {
        return 0
    }
    var leftMaxPath = +1
    var rightMaxPath = +1
    return Math.max(findMaxPath(treeNode.left), findMaxPath(treeNode.right)) + 1
}

val map = HashMap<Int, Int>()
var postIndex = 0
var _postOrder: IntArray? = null

fun buildTree(postOrder: IntArray, inOrder: IntArray): TreeNode? {
    if (postOrder.isEmpty() || inOrder.isEmpty()) {
        return TreeNode(0)
    }
    _postOrder = postOrder
    var idx = 0
    for (i in inOrder) {
        map[inOrder[i]] = idx++
    }

    postIndex = postOrder.lastIndex
    return helper(0, postOrder.lastIndex)

}

fun helper(inLeft: Int, inRight: Int): TreeNode? {
    if (inLeft > inRight) {
        return null
    }
    val root = _postOrder?.get(postIndex) as TreeNode
    postIndex--;
    val index = map[root.`val`]
    if (index != null) {
        root.right = helper(index + 1, inRight)
    }
    if (index != null) {
        root.left = helper(inLeft, index - 1)
    }
    return root
}