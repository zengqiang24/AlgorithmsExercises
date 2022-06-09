package review.sort;

import org.jetbrains.annotations.NotNull;

public class SelectSort extends ISort {

    @Override
    void sort(@NotNull Comparable[] array) {
        if (array == null || array.length ==0){
            return;
        }
        int N = array.length;
         for(int i = 0; i<N; i++){
             int min = i;
             for (int j = i+1; j < N; j++){
                 if (less(array[j],array[min])){
                     min = j;
                 }
             }
             exchange(array,i,min);
         }
    }

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        String array[] = {"A","B","K","Q","C","H"};
        selectSort.sort(array);
        selectSort.showResult(array);
    }
}
