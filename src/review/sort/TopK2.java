package review.sort;

import java.util.Arrays;

public class TopK2 {
    int k = 0;
    public int[] getLeastNumbers(int[] arr, int k) {
        this.k = k;
        int[] result = new int[k];
        int lo = 0, hi = arr.length - 1;
        sort(arr, lo, hi);
        for (int i = 0; i < k; i++) result[i] = arr[i];
        return result;
    }
    public void sort(int[] arr, int lo, int hi) {
        if (lo > hi) {
            return;
        }
        int pivot = partition(arr, lo, hi);
        if (pivot < k) {
            sort(arr, pivot + 1, hi);
        } else if (pivot > k) {
            sort(arr, lo, pivot - 1);
        }
    }
    public int partition(int[] arr, int i, int j) {
        int index = i;//取当前区间第一位为分界值
        //左右哨兵分别为 i+1，j
        j = j + 1;
        while (true) {//如果i，j交叉则代表已找到当前分界值，跳出左右扫描，
            while (i++ < arr.length - 1 && arr[i] < arr[index]) {}//如果i大于等于分界点index 则暂停}
            while (j-- > 0 && arr[j] > arr[index]) {}//如果j小于分界点index 则暂停
            if (i >= j) break;///如果交叉了则跳出扫描，新的交界点已经找到了。
            swap(arr, i, j); //左右哨兵交换位置，
        }
        swap(arr, index, j);//交换j和index，使得分界点左边的元素都小于等于它，而分界点右边都元素都大于它。
        return j;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        TopK2 topK2 = new TopK2();
        int arr[] = {0, 1, 2, 1};
        int[] ints = topK2.getLeastNumberByMaxHeap(arr, 1);

        System.out.println("ints = " + Arrays.toString(ints));
    }

    int[] getLeastNumberByMaxHeap(int arr[], int k) {
        HeapSort2 heap = new HeapSort2();
        heap.getTopK(arr, k);
        int[] res = new int[k];
        for (int i = 0; i <= k - 1; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
