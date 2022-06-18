package recursion;

public class HeadAndTailRecursion {
    public static void main(String[] args) {
//        System.out.println(recursionHead(3));
//
//        System.out.println(recursionTail(3, 1));
        int result = fibonacciTail(4, 0, 1);
        System.out.println(result);
    }

    /**
     * Head recursion 递归过程
     * //1
     * //   2*fibonacciHeadRecursion(1)
     * //      3 * fibonacciHeadRecursion(2)
     * <p>
     * //    2 * 1
     * //  3 * 2
     * //6
     *
     * @param N
     * @return
     */
    private static int recursionHead(int N) {
        if (N <= 1) {
            return 1;
        }
        int nextValue = recursionHead((N - 1)); // 1. calling the method recursively.
        return N * nextValue; //2. Do some operations.
    }

    private static int recursionTail(int N, int result) {
        if (N == 1) {
            return result;
        }
        int updateResult = N * result; // 1. Do some operations.
        return recursionTail(N - 1, updateResult); // 2. calling the method recursively.
    }
    //0 1 1 2 3 5;
    private static int fibonacciTail(int n, int a, int b) {
        if(n == 0) return a;
        if(n == 1) return b;
        return fibonacciTail(n-1,b, a+b);
    }
}
