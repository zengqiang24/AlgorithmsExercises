package top15classic

class FindThirdNodeInLinkList {
    fun findThirdNode(head: Node, k: Int) : Int {
        var slow = head
        var fast = head
        var length = 1
        fast = fast.nextNode!! //fast ->point 2
        while (fast.nextNode != null) {
            if (length == k ){
                return slow.value
            }
            fast = fast.nextNode!!
            slow = slow.nextNode!!
            length++;//fast ->point3
        }
        return slow.value
    }
}
fun main() {
    val node = getNode()//1  5  2  3   7
    val result = FindThirdNodeInLinkList().findThirdNode(node, 5)
    println("findThirdNode result  = $result")

}