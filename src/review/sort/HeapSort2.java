package review.sort;

import java.util.Arrays;

public class HeapSort2 {
    void heapify(int arr[], int n, int i) {
        if(i >= n) {
            return;
        }
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;
        if (c1 < n && arr[c1] > arr[max]) {
            max = c1;
        }

        if (c2 < n && arr[c2] > arr[max]) {
            max = c2;
        }
        if (max != i) {
            swap(arr, max, i);
            heapify(arr, n, max);
        }
    }

    void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void heapSort(int arr[], int n) {
        buildHeap(arr, n);

        for (int i = n - 1; i >=0; i--) {
            swap(arr,i, 0);
            heapify(arr, i, 0);
        }
    }

    private void buildHeap(int[] arr, int n) {
        int lastNode = n - 1;
        int parent = (lastNode - 1) / 2;
        for (int i = parent; i >= 0; i--) {  //从最后一个子树的父节点开始，倒着递减，来构建堆
            heapify(arr, n, i);
        }
    }

    void getTopK(int arr[], int k) {
        int n = arr.length;
        buildHeap(arr, n);
        for (int i = n - 1; i >= 0 ; i--) {
            swap(arr, i, 0);
            if(i  == k) {
                break;//左边的元素 k - 1起即是最小k个数
            }
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 1, 2, 3, 4, 5, 9, 8}; // i = 1 , 2 , 3, 4, 5, 6,7, 8
        HeapSort2 heapSort2 = new HeapSort2();
        heapSort2.heapSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
