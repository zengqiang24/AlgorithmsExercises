package Recursion;

/**
 * Created by qiangzeng on 16/12/17.
 */
public class RecursionPrictice {
    public static String exR1(int n) {
        if (n <= 0) return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

    public static void main(String[] args) {
        System.out.println(exR1(6));
        //  rxr1 3  6   rxr14 6
        // “” +3 + exr1 1  +3
        // “” +3 + “” +1 +1 +3  + 6  exr1 1 +4 +exr1 2 +4
        // “”+1+”+1+ 4 + “ “ 2 +”” 2+4 + 6
        //output:   311361142246
        //
        //
    }
}
