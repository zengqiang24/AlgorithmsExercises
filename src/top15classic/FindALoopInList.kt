package top15classic

class FindALoopInList {
    // 1 5 2 3 7 4
    fun hasLoop(head: Node): Boolean {
        var slow = head
        var fast = head
        while(true) {
            if (fast?.nextNode == null){
                false;
            }

            slow = slow.nextNode!!
            if (fast.nextNode?.nextNode == null) {
                return false
            }
            fast = fast.nextNode?.nextNode!!

            if (fast.nextNode == null){
                false;
            }

            if (slow.value == fast.value) {
                return true
            }
        }
        return true
    }
}

fun main() {
    val head = getNode()
    println("hasLoop in list = ${
        FindALoopInList().run {
            this.hasLoop(head)
        }
    }")
}