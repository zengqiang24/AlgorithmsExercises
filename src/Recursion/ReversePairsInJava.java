package Recursion;


public class ReversePairsInJava {
    public static void main(String[] args) {
        ReversePairsInJava reversePairsInJava = new ReversePairsInJava();
        int[] nums = new int[]{7,5,6,4};
        int count = reversePairsInJava.reversePairs(nums);
        System.out.println("逆序对之和 = " + count);
    }
    public int reversePairs(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }
        int[] copy = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
        int[] aux = new int[nums.length];
        return reversePairs(copy, 0, nums.length - 1, aux);
    }

    public int reversePairs(int[] nums, int left, int right, int[] aux) {
        if(left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftPairsCount = reversePairs(nums, left, mid, aux);
        int rightPairsCount = reversePairs(nums, mid + 1, right, aux);
        int crossPairsCount = mergeAndCount(nums, left, mid, right, aux);
        return leftPairsCount + rightPairsCount + crossPairsCount;
    }
    public int mergeAndCount(int[] nums, int left, int mid, int right, int[] aux) {
        int count = 0;
        //copy data to aux array
        for(int i = left; i <= right; i++) {
            aux[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int k  = left;
        while(k <= right) {
            if(i > mid) {
                nums[k] = aux[j];
                j++;
            } else if (j > right){
                nums[k] = aux[i];
                i++;
            } else if(aux[i] <= aux[j]) {
                nums[k] = aux[i];
                i++;
            } else if(aux[j] <= aux[i]){
                nums[k] = aux[j];
                count += (mid - i + 1);
                j++;
            }
            k++;
        }
        return count;
    }
}
