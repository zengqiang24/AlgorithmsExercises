package Sort;

/**
 * asc for right to left
 * Created by qiangzeng on 16/12/15.
 */
public class InsertSort extends ISort {
    @Override
    void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1]))
                    exch(a, j, j - 1);
                else
                    break;

            }
        }
    }

    public static void main(String[] args) {
        String[] a = {"E", "A", "b", "C", "W", "I", "Q", "R"};
        InsertSort mInsertSort = new InsertSort();
        mInsertSort.sort(a);
        mInsertSort.show(a);
    }
}
