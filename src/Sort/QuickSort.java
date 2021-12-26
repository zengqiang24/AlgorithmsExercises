package Sort;

/**
 * Created by qiangzeng on 17/4/27.
 */
public class QuickSort extends ISort {


    @Override
    void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);

    }

    public void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
            int j = partition(a,lo,hi);
            sort(a, lo, j - 1);
            sort(a, j+1, hi);
        }

    public int partition(Comparable[] a,int lo,int hi) {
        int i = lo;
        int j =hi+1;
        Comparable v = a[lo];

        while (true){
            while (less(a[++i],v)){
            }
            while (less( v,a[--j])){}
            if (i>=j)break;
            exch(a,i,j);
        }

        exch(a,lo,j);
        return j;
    }

    public static void main(String[] args) {
        String[] a = {"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        QuickSort mQuickSort = new QuickSort();
        mQuickSort.sort(a);
        mQuickSort.show(a);
    }
}
