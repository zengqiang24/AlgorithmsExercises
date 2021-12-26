package review.sort;

public class InsertSort extends ISort {
    @Override
    void sort(Comparable[] array) {
        if (array == null || array.length == 0 || array.length == 1) {
            return;
        }
        int N = array.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(array[j], array[j - 1]))
                    exchange(array, j - 1, j);
                else
                    break;
            }
        }
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        String[] array = {"b", "A", "K", "O", "B"};
        insertSort.sort(array);
        insertSort.showResult(array);
    }
}
