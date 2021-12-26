package review.sort;

public class MergeSort extends ISort {
    public void merge(Comparable[] array, Comparable[] aux, int lo, int mid, int hi) {
        //2.原地合并中，如何把原数组拷贝到辅助数组
        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }
        int i = lo;
        int j = mid + 1;

        //3.把辅助数组更新到原数组里面，合并数组，注意i，j的边界大小
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                array[k] = aux[j++];//j<=k<=hi
            } else if (j > hi) {
                array[k] = aux[i++];//i<=k<=mid
            } else if (less(aux[i], aux[j])) {
                array[k] = aux[i++];
            } else {
                array[k] = aux[j++];
            }
        }
    }

    public void sort(Comparable[] array, Comparable[] aux, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(array, aux, lo, mid);
        sort(array, aux, mid + 1, hi);
        merge(array, aux, lo, mid, hi);
    }

    @Override
    void sort(Comparable[] array) {


    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        String[] array = {"K", "O", "J", "A", "B", "P", "W", "E", "X"};
        int lo = 0;
        int hi = array.length-1;
        Comparable[] aux = new Comparable[array.length];
        //1.注意排序数组边界大小 hi
        mergeSort.sort(array, aux, lo, hi);
        mergeSort.showResult(array);

    }

}
