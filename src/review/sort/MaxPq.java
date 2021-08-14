package review.sort;

import java.util.NoSuchElementException;

/**
 * 其于堆的优先队列
 *
 * @param <Key> 队列内需要排序和比较的元素
 */
public class MaxPq<Key extends Comparable> {
    private static  int MAX = 0;
    private int N = 0;
    private Key[] pq = null;

    public MaxPq(int count) {
        MAX = count;
        pq = (Key[]) new Comparable[MAX + 1];
    }

    private void sink(int k) {
        while (2 * k <= N) { //从左子节点开始检测
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;  //如果左子节点小于右子节点，则取右子节点比较
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && !less(k, k / 2)) { //如果没有到达最顶部的root节点，而且子节点不小于根结点，那么继续上浮。
            exch(k, k / 2);//因为子节点不小于父节点，所以需要交换内容，来上浮。
            k = k / 2; //更新索引，继续向上右节点是2K+1 = N检查是否要上浮。
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(j) < 0;
    }

    private void exch(int i, int j) {
        Key key = pq[i];
        pq[i] = pq[j];
        pq[j] = key;
    }

    private boolean isEmpty(){
        return N == 0;
    }
    public Key removeMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key max  = pq[1];
        exch(1,N--);//n减去1，是因为下一步sink的时候，最后一个元素已经是不需要比较的已经需要移除的数。
        sink(1);
        pq[N+1] = null;//把数组末尾需要移除的最大数置为null,垃圾回收
        return max;
    }

    public void insert(Key key) {
        if (N>=MAX){
            delMin();
        }
        pq[++N] = key;
        swim(N);
    }

    private void delMin() {
        pq[N--] = null;
    }

    public void show(){
        for (int i = 1; i <= MAX; i++) {
            System.out.print(pq[i]+" ");

        }
    }
}
