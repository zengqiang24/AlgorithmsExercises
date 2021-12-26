package array;

import java.util.concurrent.CountDownLatch;

public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix =
                       {{1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12}};
        int[] result = spiralOrder(matrix);
        for (int i : result) {
            System.out.print(" " + i);
        }
    }

    public static int[] spiralOrder(int[][] matrix) {
        int t = 0;
        int b = matrix.length-1;
        int l = 0;
        int r = matrix[0].length -1;
        int[] result = new int[matrix.length * matrix[0].length];
        int index = 0;
        while (index < result.length) {
            //from left to right;
            for (int i = l; i <=r; i++) {
                result[index++] = matrix[t][i];
            }
            if (t < b) {
                t++;
            } else {
                break;
            }

            //from top to bottom
            for (int i = t; i <=b; i++) {
                result[index++] = matrix[i][r];
            }
            if (r > l) {
                r--;
            } else {
                break;
            }

            //from right to left
            for (int i = r; i >= l; i--) {
                result[index++] = matrix[b][i];
            }
            if (b > t) {
                b--;
            } else {
                break;
            }
            //from bottom to top
            for (int i = b; i >=t; i--) {
                result[index++] = matrix[i][l];
            }
            if (l < r) l++;
            else break;

        }
        return result;
    }
}
