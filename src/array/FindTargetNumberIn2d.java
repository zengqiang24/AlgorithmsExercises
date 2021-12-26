package array;

public class FindTargetNumberIn2d {
    static int[][] nums = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
    };

    static int[] array = {2, 2, 2, 0, 1};
    static int[] array2 = {3,4,5,1,2};
    static int[] array3 = {3, 1};
    static int[] array4 = {1,3 ,5};

    static int[][] matrix2 = {{-5}};

    public static void main(String[] args) {
//        boolean result = findNumberIn2DArray(matrix2, -5);
        int result = minArray(array4);

        System.out.print("result = " + result);
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int column = matrix[0].length - 1;
        int row = 0; //从最右上角开始。
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] > target) {//如果matrix[row][column] 大于目标值，则目标值一定在column左边。
                column--;
            } else {
                row++; //如果matrix[row][column] 小于目标值，则目标值一定在row下边。
            }
        }
        return false;
    }

    public static int minArray(int[] numbers) {
        //找出右边的增序的子数组第一个元素，即所求结果。
        if (numbers.length == 1) {
            return numbers[0];
        }
        int lo = 0;
        int hi = numbers.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (numbers[mid] > numbers[hi]) {
                //有右边增序数组在mid的右侧；
                lo = mid + 1;
            } else if (numbers[mid] < numbers[hi]) {
                hi = mid ;
            } else {
                hi --;
            }
        }
        return numbers[lo];
    }
}
