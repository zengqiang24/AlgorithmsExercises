package binarysearch;

public class UPBOUND {
    public int upper_bound_1 (int n, int v, int[] a) {
        // write code here
        if(a == null || a.length == 0){
            return n + 1;
        }

        int low = 0;
        int high = a.length -1;
        int mid = 0;
        while(low < high){
            mid = (high - low) / 2 + low;
            if(a[mid] < v){
                low = mid+1;
            } else if (a[mid] > v){
                high = mid - 1;
            }else{
                return mid;
            }
        }
        if(a[mid] == v){
            return mid;
        }
        return n+1;
    }
    int upper_bound_(int n, int v, int[] a) {
        // write code here
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] >= v) {
                if (mid == 0 || a[mid - 1] < v) return mid + 1;
                else
                    right = mid;
            }
            else
                left = mid + 1;
        }
        return n + 1;
    }
    public static void main(String[] args) {
        UPBOUND upbound = new UPBOUND();
        int[] array = {1,1,2,3,7,7,7,9,9,10};
        int i = upbound.upper_bound_(10, 2, array);
        System.out.println("index = " + i);
    }
}
