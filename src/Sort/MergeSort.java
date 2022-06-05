package Sort;

/**
 * Created by qiangzeng on 16/12/22.
 */
public class MergeSort extends ISort {

    @Override
    void sort(Comparable[] a) {
        aux = new Comparable[a.length];    // Allocate space just once.
        sort(a, 0, a.length - 1);
    }

    private static Comparable[] aux;      // auxiliary array for merges

    private static void sort(Comparable[] a, int lo, int hi) {  // Sort a[lo..hi].
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        System.out.println(lo + " " + mid + " " + hi);
        sort(a, lo, mid);       // Sort left half.
        System.out.println("pre merge"+"lo:"+lo+"mid:"+mid+"hi:"+hi);
        sort(a, mid + 1, hi);     // Sort right half.
        System.out.println("merge"+"lo:"+lo+"mid:"+mid+"hi:"+hi);
        merge(a, lo, mid, hi);  // Merge results (code on page 271).
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {  // Merge a[lo..mid] with a[mid+1..hi].
        for (int k = lo; k <= hi; k++)  // Copy a[lo..hi] to aux[lo..hi].
            aux[k] = a[k];


        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++)  // Merge back to a[lo..hi].把区间格子内的元素依次排好序。
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
    }

    public static void main(String[] args) {
        String[] a = {"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        MergeSort mMergeSort = new MergeSort();
        mMergeSort.sort(a);
        mMergeSort.show(a);
        //2,1,2
        int ans = 2 ^ 1;
          ans = ans ^ 2;

        System.out.println(("ans = " + ans));
    }

    private void merge1(int[] aux, int[] array, int lo, int mid, int hi) {
        //aux:3,1,5,1,3
        //array : 1,3,1,5,4
        for(int i = lo; i <= hi; i++) {
            aux[i] = array[i];
        }
        //合并数组
        int i = lo;
        int j = mid + 1;
        int k = i;
        while(k <= hi) {
            if(aux[i] > mid) array[k] = aux[j++];
            else if(aux[j] >hi ) array[k] = aux[i++];
            else if(aux[i] < aux[j]) array[k] = aux[i++];
            else array[k] = aux[j--];
            k++;
        }
        //
    }
    private void sort(int[] aux, int[] array, int lo, int hi) {
        if(lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) /2;
        sort(aux,array, lo, mid - 1);
        sort(aux, array, mid + 1, hi);
        merge1(aux, array, lo,mid, hi);
    }
}
