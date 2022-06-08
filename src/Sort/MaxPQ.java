package Sort;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * 优先队列
 * Created by qiangzeng on 17/5/15.
 */
public class MaxPQ<Key extends Comparable<Key>> extends ISort {

    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private Key PQ[];

    public MaxPQ(int maxN) {
        PQ = (Key[]) new Comparable[maxN + 1];
    }

    @Override
    void sort(Comparable[] a) {

    }
    public Key delMax() {
        Key max = PQ[1];
        exch(PQ, 1, N--);
        PQ[N + 1] = null;
        sink(1);
        return max;
    }


    public void insert(Key value) {
        PQ[++N] = value;
        swim(N);
    }

    //上浮
    private void swim(int k) {
        while (k > 0 && less(PQ[k / 2], PQ[k])) { //如果父节点小于子节点
            exch(PQ, k, k / 2);
            k = k / 2;
        }
    }

    //下沉
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(PQ[j], PQ[j + 1])) //比较左右子节点
                j++;
            if (!less(k, j)) break;
            exch(PQ, k, j); //父节点与其中大的子节点交换
            k = j;
        }

    }

    public static void main(String[] args) {
        MaxPQ<Integer> integerMaxPQ = new MaxPQ<>(5);
        integerMaxPQ.insert(5);
        integerMaxPQ.insert(2);
        integerMaxPQ.insert(6);
    }
}
