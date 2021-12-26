package top15classic

data class Node(var value: Int, var nextNode: Node?)


fun getNode(): Node  {
//    1 5 2 3 7 4
    //construct linkList
    val node5 = Node(4, null)
    val node4 = Node(7, node5)
    val node3 = Node(3, node4)
    val node2 = Node(2, node3)
    val node1 = Node(5, node2)
    return Node(1, node1)
}