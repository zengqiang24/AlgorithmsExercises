package binarysearch;

public class BinarySearchReview {
    static int getMinumNumbers(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        //2，2 2，0，1
        int lo = 0;
        int hi = numbers.length - 1;
        int mid = lo;
        while (numbers[lo] >= numbers[hi]) {
            if (hi - lo == 1) { //如果两指针相邻，那么说明第一个指针在前递增数组的末尾，第二个指针在后递增数组的起始，且为要求的数组最小值。
                return numbers[hi];
            }
            mid = (hi + lo) / 2;
            if (numbers[lo] == numbers[hi] &&
            numbers[lo] == numbers[mid] &&
            numbers[hi] == numbers[lo]){//特殊情况2： 前后和中间数，三者相等，则需要顺序遍历。

             return minInOrder(lo, hi, numbers);
            }
            if (numbers[mid] >= numbers[lo]) {
                lo = mid;
            } else if (numbers[mid] <= numbers[hi]) {
                hi = mid;
            } else {
                return numbers[mid];
            }
        }
        return numbers[mid];//特殊情况1：如果最小值刚好在数组第一个位置。
    }

    private static int minInOrder(int lo, int hi,int[] numbers) {
     int result = numbers[lo];
        for (int i = lo+1; i <= hi ; i++) {
            if (numbers[i] < result) {
                result = numbers[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3};
        int[] numbers2 = {2, 2, 2, 0, 1};
        int[] numbers3 = {3, 1};
        int[] numbers4 = {1};
        int[] numbers5 = {1,1,1,0,1};

        int result = getMinumNumbers(numbers5);
        System.out.print(" result = " + result);
    }
}
