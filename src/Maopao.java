public class Maopao {
    public void sort(int[] arrays){
        for (int i=0; i< arrays.length;i++){
            for (int j=i; j<arrays.length;j++){
                int max = arrays[i];
                if (max<arrays[j]){
                   max = arrays[j];
                }
                arrays[i] = max;
            }
        }
    }
    public static void main(String[] args) {
        Maopao maopao = new Maopao();
        int arr[] = {4,5,3,1,2,9};
        maopao.sort(arr);
        System.out.println(arr[0]);
        System.out.println(arr[5]);
    }
}
