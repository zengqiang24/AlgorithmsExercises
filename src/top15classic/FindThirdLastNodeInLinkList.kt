package top15classic

class FindThirdLastNodeInLinkList {
    /**
     * //1  5  2  3   7
     *
     */
    fun findThirdLastNode(head: Node, k: Int) : Int {
        var slow = head
        var fast = head
         var i = k
         while (i>0){
            i--
             print("i = $i")
            fast = fast.nextNode!!
        }
        while (fast.nextNode != null){
            slow = slow.nextNode!!
            fast = fast.nextNode!!
        }
        return slow.value
    }
}
fun main() {
    val node = getNode()//1  5  2  3   7
    val result = FindThirdLastNodeInLinkList().findThirdLastNode(node, 3)
    println("findThirdNode result  = $result")

}