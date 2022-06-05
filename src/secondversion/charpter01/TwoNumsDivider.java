package secondversion.charpter01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//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
public class TwoNumsDivider {
    /**
     * 用暴力法，求两数相除的商。
     * //时间复杂度O（n)
     *
     * @return
     */
    private static int testTwoNumsDivider(int dividend, int dividor) {
        //15/2 = 7
        //用减法代替除法
        //15/2可分解成
        //1，15 - 2 = 13
        //2，13 -2 = 11
        //3，11 -2 = 9
        //4，9- 2 = 7
        //5，7-2 = 5
        //6， 5-2 = 3
        //7 3- 2= 1
        //1 < dividor
        //return 7

        int count = 0;
        int result = 0;
        while (true) {
            result = dividend - dividor;
            ++count;
            if (result >= dividor) {
                dividend = result;
                continue;
            }
            break;
        }
        return count;
    }

    static class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == 0x80000000 && divisor == -1) { //溢出只有一种情况 被除数为int的最小值，除数为-1
                //负负相减，得到的商：-2`31 > 最小值:-2`31 - 1。
                return Integer.MAX_VALUE;
            }

            //为了以防结果溢出，把被除数和除数都换算成负数
            int negative = 2;
            if (dividend > 0) {
                negative--;
                dividend = -dividend;
            }
            if (divisor > 0) {
                negative--;
                divisor = -divisor;
            }
            int result = divideCore(dividend, divisor); //核心逻辑。
            return negative == 1 ? -result : result; // 如果两者有一个是负数，则需要转化一下商。
        }

        private int divideCore(int dividend, int divisor) {
            int result = 0;
            while (dividend <= divisor) { //被除数 小于 除数； 注意这里两者都是负数
                int value = divisor;//除数
                int quotient = 1; //商
                while (value > 0xc0000000 && dividend <= value + value) { //0xc0000000最小值的一半
                    quotient += quotient;//?
                    value += value; //?
                }
                result += quotient;
                dividend -= value;
            }
            return result;
        }


        public int divideNormal(int dividend, int divisor) {
            int quotient = 0;
            while (dividend > divisor) {
                dividend = dividend - divisor;
                quotient++;
                System.out.println("result = " + quotient);
            }
            return quotient;
        }

        public int divideAdvance(int dividend, int divisor) {
            int result = 0;
            while (dividend > divisor) {
                int value = divisor;
                int quotient = 1;
                while (dividend >= value + value) {
                    quotient += quotient;
                    value += value;
                }
                result += quotient;
                dividend -= value;
            }

            return result;
        }
    }


    public static void main(String[] args) {
//        Solution solution = new Solution();
////        int quotient = solution.divide(11, 2);
//        int intMaxValue = Integer.MAX_VALUE;
//        int intMinValue = Integer.MIN_VALUE;
//        long startTime = System.currentTimeMillis();
//        System.out.println("starttime = " + startTime);
//        int quotient = solution.divideAdvance(15, 2);
//        long endTime = System.currentTimeMillis();
//        System.out.println("endtime = " + endTime);
//        long cost = endTime - startTime;
//
//        System.out.println("商等于=" + quotient + " cost = " + cost);

//        String result = addBinary("1111", "1111");

        int[] array = {2, 3, 1, 2, 4, 3};
        int[] array2 = {1,4,4};
        int target2 = 4;
        int[] array3 = {1,1,1,1,1,1,1,1};
        int target3= 11;
        int target4= 11;
        int[] array4= {1,2,3,4,5};
        int target5 = 213;
        int[] array5 = {12,28,83,4,25,26,25,2,25,25,25,12} ;
        int result = minSubArrayLen(target4, array4);
        System.out.println("result = " + result);

    }

    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0; //进位
        StringBuffer result = new StringBuffer();
        //1。 把大小在'0' - '9'的字符转换成二进制。即 ch - '0'
        while (i >= 0 || j >= 0) {
            int right = i >= 0 ? a.charAt(i--) - '0' : 0; //从最低位开始，向左扫描
            int left = j >= 0 ? b.charAt(j--) - '0' : 0;
            //二进制加法
            int sum = right + left + carry;
            carry = sum >= 2 ? 1 : 0;
            result.append(sum % 2); // 2. sum 如果大于2， 那么sum为1
        }
        if (carry == 1) //3
            result.append(carry);
        return result.reverse().toString();
    }
    //输入：
    //"1111"
    //"1111"
    //输出：
    //"10000"
    //预期结果：
    //"11110"

    //求三数之和等于0的三元组
    //可分解成两个部分：
    //1. 固定数字i
    //2.  求其他两数，且两数之和为-i
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        //1. 排序数组
        Arrays.sort(nums);
        //2. 固定一个数字i，从剩余的数组元素中，查找两数和为-i的数对。
        int i = 0;
        while (i < nums.length - 2) {
            twoSum(nums, i, result);
            //跳过重复的i
            int temp = nums[i];
            while (i < nums.length && (temp == nums[i])) {
                ++i;
            }
        }
        return result;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> result) {
        int lo = i + 1;
        int hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < -nums[i]) {
                hi--;
                continue;
            } else if (sum > -nums[i]) {
                lo++;
                continue;
            } else {
                //找到所求的三元组中，剩余的两个数字的数组下标lo，hi
                //3. 排除重复的三元组
                result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                int temp = nums[lo];
                while ((lo < hi) && temp == nums[lo]) {
                    ++lo;//去除重复的j。 三元组去重，i已经去重了，只需要跳过重复的j，即可。
                }
            }
        }
    }

    private static int minSubArrayLen(int target, int[] nums) {
        //定义双指针p0,p1，
        //从区间dx=0开始，双指针通向而行，判断是否等于target， length = p1- p0 + 1;
        int dx = 1;
        int length = 0;
        int p0 = 0;
        int p1 = 0;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == target) {
                return 1;
            }
        }
        while (dx <= nums.length - 1) {
            for (p0 = 0; p0 <= nums.length - 1 - dx; p0 += dx) {
                p1 = p0 + dx;
                System.out.println("p0 = " + p0 +", p1 = " + p1);
                if (p1 > p0 && sum(p0,p1,nums)>= target) {
                    return  p1 - p0 ;
                 }
            }
            dx++;
        }
        return length;
    }
    private static int sum(int p0, int p1,int[] nums) {
        int result = 0;
        int startIndex = p0;
        while(startIndex <= p1){
            result += nums[startIndex];
            startIndex++;
        }
        return result;
    }
}
