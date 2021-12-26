package array;

import java.util.HashSet;
import java.util.Set;

public class isStraight {
    public static void main(String[] args) {
        int[] nums= {0,0,2,2,1};
        int[] nums2 = {0,0,1,2,10};
        int[] nums3 = {0,0,1,2,5};

        System.out.print("nums =" + isStraight(nums3));

    }
    public static boolean isStraight(int[] nums) {
        //不能有重复数字
        //最大值-最小值大于5
        //满足以上条件则是顺子。
        Set<Integer> repeat = new HashSet<>();
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)continue;
             max = Math.max(max, nums[i]);
             min = Math.min(min, nums[i]);
             if (repeat.contains(nums[i]))return false;
             repeat.add(nums[i]);
        }
        return max - min >= 5;
    }
}
