package review.sort;

public class QuickSort extends ISort {
    //0 , 1 , 2 , 3, 4, 5, 6, 7, 8
    // K , O , J ,A,  B, P, W, E, X

    public void sort(int lo, int hi, Comparable array[]) {
        if (lo>=hi){
            return;
        }
        int j = partition(array, lo, hi);
        sort(lo, j-1, array);
        sort(j+1, hi, array);
    }

    public int partition(Comparable array[], int lo, int hi) {
        int i = lo;
        int j = hi;
        int v = i;
        while (i < j) {
            //右移动，a[i]比a【v]大则停止i++ ,交换arr[v]和arr[i]的内容。
            if (less(array[v], array[i])) {
                exchange(array, v, i);
            } else {
                i++;
            }

            if (less(array[j], array[v])) {
                exchange(array, j, v);
            } else {
                j--;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        String[] array = {"K" , "O" , "J" ,"A",  "B", "P", "W", "E", "X"};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);
        quickSort.showResult(array);

    }

    @Override
    void sort(Comparable[] array) {
            sort(0,array.length-1,array);
    }
}
