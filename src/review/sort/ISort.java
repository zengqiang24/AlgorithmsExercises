package review.sort;

public abstract class ISort {
    abstract void sort(Comparable[] array);

    public static boolean less( Comparable i, Comparable j) {
        return  i.compareTo(j) < 0;
    }

    void exchange(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void showResult(Comparable[] comparables) {
        for (Comparable comparable : comparables) {
            System.out.print(comparable + " ");
        }


    }

}
