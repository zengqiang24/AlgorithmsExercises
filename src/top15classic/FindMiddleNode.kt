package top15classic
//这类把时间复杂度急剧减小到线性的，一般都用双指针，一个指针遍历，另外一个做跟踪或记忆化，通过演绎过程，可以推导出来解决方案。
fun main() {
    var head = getNode()
    var middle = head
    var length = 0

    //1  5  2  3   7
    //~~~~~~~~~~~~~~~~~~~~
    //step 0: head ->  1
    //      length = 1,  middle->head;
    //step1 : head -> 5
    //      length = 2, middle ->lenth%2==0 middle = middle.next   = 5
    //step2 : head ->2
    //      length = 3, middle unchange,
    //step3, head->3
     //       length=4 middle=middle.next = 2
    //step4 head->7
    //      length = 5, middle unchange, = 2
    //step5 head->null return

    // return middle.value
    length = 1
    while (head.nextNode != null) {
        length++
        if (length % 2 == 0) {
            middle = middle.nextNode!!;
        }
        head = head.nextNode!!
    }
     println("length = $length middle = ${middle.value}")
}
