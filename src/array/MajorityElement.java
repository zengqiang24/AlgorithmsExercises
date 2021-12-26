package array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public  static int majorityElement(int[] nums) {
        int halfValue =( nums.length  )/2 ;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int k = nums[i];
            int cur = 1;
            if(map.containsKey(k)) {
                  cur = map.get(k) + 1;
                if (cur > halfValue){
                    return k;
                }
            }
            map.put(k, cur);
        }
        return 0;
    }

    public static int majorityElementByVotes(int[] nums) {
        int votes = 0;
        int x = nums[0];
        //输入: [1, 2, 3,3]
        //输出: 2
        for (int i = 0; i < nums.length; i++) {
            if (votes == 0) x = nums[i];
            votes +=  (x == nums[i]) ? 1 : -1;
        }
        return x;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] nums2 = {2,2,1,1,1,2,2};
        int result = majorityElementByVotes(nums);
        System.out.print(" " + result);

    }
}
