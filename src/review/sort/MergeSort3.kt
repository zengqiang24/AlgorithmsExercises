package review.sort

class MergeSort3 {
    fun main() {
        var array = arrayOf(1, 3, 4, 5, 6)
        var lo = 0
        var hi = array.lastIndex
        var aux = arrayOf(array.size)
        sort(array,aux,lo, hi)
    }

    fun sort(array: Array<Int>, aux: Array<Int>, lo: Int, hi: Int) {
        if (lo >= hi) {
            return
        }
        var mid = lo + (hi - lo) / 2
        sort(array, aux, lo, mid - 1)
        sort(array, aux, mid + 1, hi)
        merge(aux, array, lo, hi)
    }

    fun merge(aux: Array<Int>, array: Array<Int>, lo: Int, hi: Int) {

        var mid = lo + (hi - lo) / 2


    }

    fun swap() {

    }
}