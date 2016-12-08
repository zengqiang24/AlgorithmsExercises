package Sort;

import java.util.Comparator;

/**
 * Created by qiangzeng on 16/12/8.
 */
public class SelectSort implements ISort {

    @Override
    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    @Override
    public void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            int min = i;//指针指向最小的右边
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);

        }
    }

    @Override
    public void show(Comparable[] a) {
        for (Comparable comparable : a) {
            System.out.print(comparable + " ");
        }

    }

    public static void main(String[] args) {
        String[] a = {"E", "A", "b", "C", "W", "I", "Q", "R"};
        SelectSort selectSort = new SelectSort();
        selectSort.sort(a);
        selectSort.show(a);

    }
}
