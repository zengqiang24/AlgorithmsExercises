import java.util.Arrays;

public class Maopao {
   static int arr[] = {4,5,3,1,9,2};
    public void sort( ){
        for (int i=1; i< arr.length;i++){
            for (int j=0; j<arr.length-1;j++){
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
             }
        }
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Maopao maopao = new Maopao();
        maopao.sort( );
        System.out.println(Arrays.toString(arr));
     }
}
