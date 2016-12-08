package Sort;

/**
 * Created by qiangzeng on 16/12/8.
 */
public interface ISort {
    boolean less(Comparable v, Comparable w);

    void exch(Comparable[] a, int i, int j);

    void sort(Comparable[] a);

    void show(Comparable[] a);
}
