package secondversion.charpter02;

import java.util.HashMap;
import java.util.Map;

/**
 * 求和为k的子数组个数。
 */
public class SumOfSubArray {
    public static int subarraySum(int[] nums, int k) {

        return 0;
    }

    public static void main(String[] args) {
        int count = countSubstrings("abcba");
        System.out.println("result = " + count);
    }

    public static int findMaxLength(int[] nums) {
        //把0替换成-1
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) nums[j] = -1;
        }
        int k = 0;
        int minSubArrayLength = nums.length;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println("sum = " + sum);
            minSubArrayLength = Math.min(minSubArrayLength, map.getOrDefault(0, Integer.MAX_VALUE));
            map.put(sum, i + 1);
        }


        return minSubArrayLength;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i - 'a')]++;
            counts[s2.charAt(i - 'a')]--;
        }
        if (isAllZero(counts)) return true;
        for (int i = s1.length(); i < s2.length(); i++) {
            counts[s2.charAt(i) - 'a']++; // i 表示第二个指针
            counts[s2.charAt(i - s1.length()) - 'a']--; // i - s1.length 表示第一个指针。指针区间是s1的变位词的长度
            if (isAllZero(counts)) return true;
        }
        return false;
    }

    private boolean isAllZero(int[] counts) {
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    private static int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            count += countPalindrome(s, i, i);//
            count += countPalindrome(s, i, i + 1);
        }
        return count;
    }

    private static int countPalindrome(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length()
                && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
        return count;
    }
}
