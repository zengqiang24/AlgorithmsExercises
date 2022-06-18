package recursion.arraysort;

/**
 * 求第k大的数，用最大堆。
 */
public class KthLargestViaHeapify {
    public static void main(String[] args) {
        KthLargestViaHeapify kthLargestHeapify = new KthLargestViaHeapify();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int result = kthLargestHeapify.findKthLargest(nums, k);
        System.out.print("result!! = " + result);
    }

    public int findKthLargest(int[] nums, int k) {
        buildHeap(nums, nums.length);
        for(int i = nums.length - 1; i >= (nums.length - k + 1); i--) {
            swap(nums, i, 0);
            heapify(nums, i, 0);
        }
        return nums[0];
    }

    void buildHeap(int[] nums, int n) {
        int lastNode = n - 1;
        int parent = (lastNode - 1) / 2;
        for(int i = parent; i >= 0; i--) {
            heapify(nums, n, i);
        }
    }

    void heapify(int[] nums, int n, int i) {
        int max = i;
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        if(c1 < n && nums[c1] > nums[max]) {
            max = c1;
        }
        if(c2 < n && nums[c2] > nums[max]) {
            max = c2;
        }

        if(max != i) {
            swap(nums, max, i);
            heapify(nums, n, max);
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
 }
