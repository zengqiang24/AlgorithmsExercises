class BinarySearch {
    fun sort(x: Int, a: IntArray): Int {
        if (a.isEmpty()) {
            return -1
        }
        var startIndex = 0
        var endIndex = a.size - 1
        while (startIndex < endIndex) {
            var mid = startIndex + (endIndex - startIndex) / 2
            if (x < a[mid]) {
                endIndex = mid - 1
            } else if (x > a[mid]) {
                startIndex = mid + 1  //1.start= 2,end =4---// 2.  mid= 2+2/2=3 -->8>a[3] start=3 end =4// 3. mid=3+
            } else {
                return mid
            }
        }
        return -1
    }
}

fun main() {
    var search = BinarySearch()
    var array = intArrayOf(1, 3, 5, 7, 9)
    var result = search.sort(5, array)
    print("result =$result")
}