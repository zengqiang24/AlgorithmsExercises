package secondversion.charpter01;

import java.util.Arrays;

public class CountBit {
    public static void main(String[] args) {
        int[] result = new CountBit().countBit(5);
        System.out.println("result = " + Arrays.toString(result));
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
}

