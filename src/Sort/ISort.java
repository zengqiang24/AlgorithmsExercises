package Sort;

/**
 * Created by qiangzeng on 16/12/8.
 */
public abstract class ISort {

    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }


    public void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    abstract void sort(Comparable[] a);


    public void show(Comparable[] a) {
        for (Comparable comparable : a) {
            System.out.print(comparable + " ");
        }

    }
}
