import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.Map;

public class DynamicProgram {
    public static int fib(int n) {
        int a = 0;
        int b = 1;
        int sum;
        for (int i = 0; i < n; i++) {
            sum = a + b;
            b = a;
            a = sum;
        }
        return a;

    }

    public static int numWays(int n) {
        int a = 1, b = 1, sum;

        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    /**
     * 股票最大的利润
     * @param prices [7,1,5,3,6,4]
     * @return
     */
    public  static int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        int n = prices.length;
        int[] dp = prices;
        for(int i = 1; i < n; i++) {
            min = Math.min(dp[i] , min);//最低价格
            maxProfit =Math.max(maxProfit,(dp[i] - min));//目前最大利润
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        //0、1、1、2、3、5、8、13、21、34

//        int sum = numWays(7);
        int prices[] = {7,1,5,3,6,4};
        int prices2[] ={7,6,4,3,1};
        int maxProfit = maxProfit(prices2);
        System.out.println("maxProfit = " + maxProfit);
    }
}
