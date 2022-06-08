import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FindRepeatNumber {
    /**
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     */
    private static int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                continue;
            }
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            swap(nums, i, nums[i]);
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Boolean> mLinkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            mLinkedHashMap.put(chars[i], !mLinkedHashMap.containsKey(chars[i]));
        }

        Set<Map.Entry<Character, Boolean>> entries = mLinkedHashMap.entrySet();
        for (Map.Entry<Character, Boolean> entry : entries) {
            if (entry.getValue()) return entry.getKey();
        }
        return ' ';
    }

    //nums = [5,7,7,8,8,10], target = 8
    public static int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int left = 0;
        int right = 0;
        int m = 0;
        while(i <= j) {
            m = (i+j)/2;
            if(nums[m] <= target){ //右边界 在 [m+1, j] 中
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        right = i;
        i = 0;j = nums.length - 1;
        while(i <= j) {
            m = (i+j) / 2;
            if(nums[m] >= target){ //左边界 在 [i, m-1] 中
                j= m - 1;
            } else {
                i = m + 1;
            }
        }
        left = j;
        return right - left - 1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.print("result = " + search(nums, 8));
    }
}
