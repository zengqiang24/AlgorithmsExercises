package secondversion.charpter01;

import java.util.Arrays;

public class CountBit {
    public static void main(String[] args) {
//        int[] result = new CountBit().countBit(5);
//        System.out.println("result = " + Arrays.toString(result));
//        int i = 1;
//        int b = i << 1; //左移1位，最右位补0
//        System.out.println(" b = " + b); //b = -2
        int[] nums = {1, 0, 1, 2, 1, 0, 0};
//        int result = new CountBit().getNumber(nums);
//        System.out.println("result " + result);
        CountBit countBit = new CountBit();
        String[] words = {"abcw", "foo", "bar", "fxyz", "abcdef"};
        int maxLength = countBit.getMaxProduct(words);
        System.out.println("maxProduct = " + maxLength);
    }

    public int[] countBit(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            //计算整数i的二进制表示中1的个数
            int j = i;
            while (j != 0) {
                j = j & (j - 1);
                result[i] += 1;
            }
        }
        return result;
    }

    public int getNumber(int[] nums) {
//1. 统计数组中整数的二进制形式的每一个数位i相加的和
        int[] sumBits = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                sumBits[i] += ((num >> (31 - i)) & 1);
            }
        }
        //此时每个数位的和已经求出来了
        //我们再来计算每一个数位整数3的余数，来确认最终数字二进制形式每一个位结果。
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + sumBits[i] % 3; //左移一位，补上最新结果。
        }
        return result;
    }

    public int getMaxProduct(String[] words) {
        int maxProduct = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                boolean isDuplicate = hasDuplicateChar(words[i], words[j]);
                if (!isDuplicate) {
                    System.out.println("word : " + words[i] + ", word2 = " + words[j]);
                    int sum = words[i].length() * words[j].length();
                    if (maxProduct < sum) maxProduct = sum;
                }
            }
        }
        return maxProduct;
    }

    /**
     * 核心部分是判断两个字符串之间是否包含重复的字符。
     *
     * @param word
     * @param word1
     * @return
     */
    private boolean hasDuplicateChar(String word, String word1) {
        char[] a = word.toCharArray();
        char[] b = word1.toCharArray();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    return true;
                }
            }
        }
        return false;
    }

}

