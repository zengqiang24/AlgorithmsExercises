package secondversion.charpter01;
//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
public class TwoNumsDivider {
    /**
     * 用暴力法，求两数相除的商。
     * //时间复杂度O（n)
     * @return
     */
    private static int testTwoNumsDivider(int dividend, int dividor){
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
        while(true){
            result = dividend - dividor;
            ++count;
            if(result >= dividor){
                dividend = result;
                continue;
            }
            break;
        }
        return count;
    }

    static class Solution {
        public int divide (int dividend, int divisor) {
            if(dividend == 0x80000000 && divisor == -1) { //溢出只有一种情况 被除数为int的最小值，除数为-1
                //负负相减，得到的商：-2`31 > 最小值:-2`31 - 1。
                return Integer.MAX_VALUE;
            }

            //为了以防结果溢出，把被除数和除数都换算成负数
            int negative = 2;
            if(dividend > 0) {
                negative--;
                dividend = -dividend;
            }
            if(divisor > 0) {
                negative--;
                divisor = -divisor;
            }
            int result = divideCore(dividend, divisor); //核心逻辑。
            return negative == 1 ? -result : result; // 如果两者有一个是负数，则需要转化一下商。
        }

        private int divideCore (int dividend, int divisor) {
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
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int quotient = solution.divide(11, 2);
        System.out.println("商等于=" + quotient);
    }
}
