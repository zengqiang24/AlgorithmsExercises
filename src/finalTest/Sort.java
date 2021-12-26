package finalTest;

public class Sort {
    private static int[] array = {11, 1, 2, 15, 8, 10, 5};

    public static void main(String[] args) {
//        bubble();
        int left = 0;
        int right = array.length - 1;
//        int[] aux = new int[array.length];
//        sort(left, right, array, aux);
//        quickSort(left, right, array);
//        showResult();
        heapSort();
        showResult();
    }

    public static void showResult() {
        for (int i : array) {
            System.out.print(" " + i);
        }
    }

    /**
     * 冒泡排序
     */
    public static void bubble() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1, array);
                }
            }
        }
        for (int i : array) {
            System.out.print(" " + i);
        }
    }


    /**
     * 合并排序
     * private static int[] array = {11, 2, 1, 5, 3, 1};
     * <p>
     * <p>
     * 0 ， 5
     * <p>
     * 1
     */
    public static void sort(int left, int right, int[] array, int[] aux) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        sort(left, mid, array, aux);//左半边完全排好序
        sort(mid + 1, right, array, aux); //右半边完全排好序
        merge(left, right, mid, array, aux);//最后合并排序
    }

    //重点是如何合并
    private static void merge(int left, int right, int mid, int[] array, int[] aux) {
        for (int k = left; k <= right; k++) {
            aux[k] = array[k];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {//填坑法，把最小值填入坑位中，代表那个坑位排好序，无需再排序了，然后k++
            if (i > mid) {
                array[k] = aux[j++];
            } else if (j > right) {
                array[k] = aux[i++];
            } else if (aux[i] > aux[j]) {
                array[k] = aux[j++];
            } else {
                array[k] = aux[i++];
            }
        }
    }

    /**
     * array = {11, 2, 1, 5, 3, 1};
     */
    public static void quickSort(int lo, int hi, int[] array) {
        if (hi <= lo) return;
        int j = partition(lo, hi, array);
        quickSort(lo, j - 1, array);
        quickSort(j + 1, hi, array);
    }

    /**
     * array = {11, 2, 1, 5, 3, 1};
     * pivot = lo=0;
     * <p>
     * <p>
     * <p>
     * <p>
     * 找到k值，使得区间【lo,k] < [k,hi], 返回结果k。
     *
     * @param lo
     * @param hi
     * @param array
     * @return 两只蚂蚁 相向而行，发现大于基准点时，停留等待另外一只蚂蚁小于基准点。都停止时，交换彼此元素后，继续行走。直到彼此相撞时，交换元素得到K
     */
    private static int partition(int lo, int hi, int[] array) {
        int k = lo;
        int i = lo;
        int j = hi + 1;

        while (true) {
            while (i < hi - 1 && array[++i] < array[k]) {
                if (i == hi) break;
            }
            while (array[--j] > array[k]) {
                if (j == lo) break;
            }

            if (i <= j) {
                break;
            }
            //如果上面两个while，都break了，说明此时pivot位于  a[j]...  pivot...a[i],故，我们要交换i和j的内容。
            swap(i, j, array);
        }

        swap(lo, j, array);
        return j;
    }

    //{11, 1, 2, 15, 8, 10,5};   什么是完全二叉树，平衡二叉树，
    //    11
    //  1     2
    //15  8 10  5


//// result: 15
    //   11    10
//   1   8   2  5

    /**
     *     5     1
     *   11 10
     *  1 8 2     2*i = 6
     *
     *    11   i =2
     *  5   10
     * 1 8 2
     *
     *    11 i =3
     *  8   10
     *1   5 2
     */

    //
    // 15 11 10 1 8 2 5
    public static void heapSort() {
        //二叉堆是一种完全二叉树，大顶堆，根节点大于等于子节点，
        //构造大顶堆
        int n = array.length - 1;// n =7
        for (int k = n / 2; k >= 1; k--) {
            if (less(2 * k, 2 * k + 1)) {
                if (less(k, 2 * k + 1)) swapForHeap(k, 2 * k + 1, array);
            } else {
                if (less(k, 2 * k)) swapForHeap(k, 2 * k, array);
            }
        }
        //取出根节点，然后重新构造大顶堆，循环，则可以得到一个升序的数组。
//
        int k = array.length;
        for (int i = 1; i <= k; i++) {
            swapForHeap(1, k - i + 1, array);
            sink(1, k - i, array);
        }
    }

    private static void sink(int i, int n, int[] array) {
        while (2 * i  <= n) {
            if (2 * i + 1 <= n && less(2 * i, 2 * i + 1)) {
                if (less(i, 2 * i + 1)) swapForHeap(i, 2 * i + 1, array);
            } else {
                if (less(i, 2 * i)) swapForHeap(i, 2 * i, array);
            }
            i++;
        }
    }

    public static void topK() {
        //如果数据很多，则用堆排序，
        

        //如何很少则用快速排序。
    }

    public static boolean less(int i, int j) {
        return array[i - 1] < array[j - 1];
    }

    private static void swap(int j, int i, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    private static void swapForHeap(int j, int i, int[] array) {
        int temp = array[j - 1];
        array[j - 1] = array[i - 1];
        array[i - 1] = temp;
    }
}
