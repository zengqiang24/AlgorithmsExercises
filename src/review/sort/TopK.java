package review.sort;


import java.util.ArrayList;


public class TopK {

    public static void main(String[] args) {
        int topK = 3;//维护最大的3个数，采用小顶堆
        int n = 8;//要输入10个数

        MaxPq<Integer> integerMaxPq = new MaxPq<>(topK);
        int[] arr = {1, 3, 10, 4, 9, 2, 5, 7};
        for (int i = 0; i < n; i++) {
             integerMaxPq.insert(arr[i]);
        }

        System.out.println("数据流中最大k个数分别是：");
        integerMaxPq.show();
    }

}
