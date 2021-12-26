package Sort

//
fun main() {
    var nums = arrayOf(99,99)
    sort(0, nums.size-1, nums, 0)
    print("sorted nums = ${nums.contentToString()}")
}

fun sort(left: Int, right: Int, nums: Array<Int>, recursionLevel: Int) {
    log("拆分问题子问题",left, right, recursionLevel)
    if (left >= right) {
        log("递归到底",left, right, recursionLevel)
        return
    }
    var p = partition(left, right, nums)
    sort(left, p - 1, nums, recursionLevel + 1)
    sort(p + 1, right, nums, recursionLevel + 1)
}

/**
 * 选择基准点p， 使得子数组[left, p - 1] <= p <= 子数组 [p+1, right]
 */
fun partition(left: Int, right: Int, nums: Array<Int>): Int {
    var i = left
    var j = right + 1
    var v = nums[left]
    while (true) {
        while (less(nums[++i], v)){  //p的左边都要比p小
            if(i == right) break
        }

        while (less(v, nums[--j])) {  //p的右边都要比p大
            if(j == left) break
        }
        if(i >= j) break
        swap(i, j, nums)
    }
    swap(left, j, nums)
    return j
}

/**
 * 打印递归过程
 */
fun log(msg: String, left: Int, right: Int, recursionLevel: Int){
    val sb = StringBuffer()
    sb.append(" ".repeat(recursionLevel))
    sb.append(msg)
    sb.append(":[$left, ")
    sb.append("$right]")
    println(sb.toString())
}

fun less(i: Int, j: Int) = i <= j

fun swap(i: Int, j: Int, nums: Array<Int>) {
    var temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}


