package review.sort;

import java.util.Arrays;

public class HeapSort {
 private static int[] array = {4,1,2,3,4,5,9,8}; // i = 1 , 2 , 3, 4, 5, 6,7, 8
    private static int N = 8;
    private static void exchange(int i, int j){
        int temp = array[i-1];
        array[i-1] = array[j-1];
        array[j-1] = temp;
    }

    private static boolean less(int i, int j){
        return array[i-1] < array[j-1];
    }

    private static void sink(int k , int n){
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j,j+1)) j++;
            if (!less(k,j)) break;
            exchange(j,k);
            k = j;
        }
    }

    /**
     *      4
     *    1   2
     *   3 4 5  9
     *  8
     *
     */

 //
 public static void main(String[] args) {
     //heapify phase
     for (int i = N/2; i >=1; i--) {
         sink(i, N);//start from 3
     }

     //sortdown phase
     int k = N;
     while(k > 1){
         exchange(1,k--);
         sink(1,k); //  排序子堆。所以此时遍历的数目为k
     }

     System.out.println(Arrays.toString(array));

 }
}
