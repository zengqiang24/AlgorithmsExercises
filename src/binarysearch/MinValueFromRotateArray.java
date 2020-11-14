package binarysearch;

public class MinValueFromRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0){
            return 0;
        }
        int low =0;
        int h = array.length -1;
        int m = 0;
        while(low<h){
            if (array[low] < array[h]){
                return array[low];
            }
            m = (h-low) / 2 + low;
            //to right
            if(array[m]>array[low]){
                low = m+1;
            }else if(array[m]<array[low]){
                //to left
                h = m;
            }else{
                low++;
            }

        }
        return array[low];
    }

    public static void main(String[] args) {
        int[] array = {6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,
                       9170,9359,9719,9895,9896,9913,9962,154,293,334,
                       492,1323,1479,1539,1727,1870,1943,2383,2392,2996,
                       3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,
                       5448,5668,5706,5725,6300,6335};
        int i = new MinValueFromRotateArray().minNumberInRotateArray(array);
        System.out.println("array length = "+array.length + "    min value = " + i);
    }
}
