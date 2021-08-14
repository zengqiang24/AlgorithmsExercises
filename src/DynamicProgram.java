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


    public static void main(String[] args) {
        //0、1、1、2、3、5、8、13、21、34

        int sum = numWays(7);
        System.out.println("sum = " + sum);
    }
}
