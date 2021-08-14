package review.sort;

import java.util.Arrays;

public class QuickSort2 {        //N=8 lo=0, hi=7,     i = 0, j = 8;
    private static int[] array = {6, 1, 2, 8, 7, 99, 10, 10, 1};

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //从子序列a[lo,hi]中找到基准点a[j]，通过交换左右两个指针的值的方法，保证数列a[lo,hi]是以a[lo...j-1] < a[j] < a[j+1...hi]的顺序排列。
    public static int partition(int[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = array[lo];

        while (true) {//++i 先加1，是因为基准点在i=0，所以跳过它。
            while (array[++i] < v) { //左指针与基准点比较，如果小于基准点，则向右移动。若碰到左指针的值大于基准点的值，停止移动。
                if (i == hi) break; //如果左指针到了右边哨兵，则停止移动，
            }
            //--j,是因为末尾hi也需要比较，且与上文代码风格保持一致，可读。
            while (array[--j] > v) { //右指针与基准点比较，如果大于基准点，则向左移动，若碰到右指针的值小于基准点的值，停止移动
                if (j == lo) break; //如果左指针已经达到左哨兵，则停止移动。
            }

            if (i >= j) { //如果左右指针交叉了，则停止拆分序列
                break;
            }

            swap(array, i, j);//如果上面两个while，都break了，说明此时pivot位于  a[j]...  pivot...a[i],故，我们要交换i和j的内容。
            // 交换左右两个指针的值，保证数列a[lo,hi]是以a[lo...j-1] < a[j] < a[j+1...hi]的顺序排列。
        }

        swap(array, lo, j); //遍历完毕，找到新基准点j，并替换旧基准点v
        return j; //返回基准点j
    }

    public static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = partition(arr, lo, hi);
        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }

    public static void main(String[] args) {
        sort(array, 0, array.length - 1);
        System.out.print(Arrays.toString(array));
    }
}
