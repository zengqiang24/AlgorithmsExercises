public class Test2 {
    private static boolean DEBUG = false;

    public static void main(String[] args) {
        String input = "I am a dog";
        switchString(input);
    }

    /**
     * input :“I am a dog."
     *
     * 1
     * ->
     * output : "dog a am I."
     * dog a am I.
     *
     * @return
     */
    private static String switchString(String inputStr) {
        if (inputStr == null) {
            return "";
        }
        String result = "";
        //0.先配置
        int n = inputStr.length();
        // 确认首尾指针
        int firstPointer = 0;
        int dotIndex = inputStr.lastIndexOf('.');
        if (DEBUG) {
            System.out.println("dotIndex: " + dotIndex);
        }
        boolean hasDot = dotIndex == inputStr.length() - 1;//包含句号。
        System.out.println("hasDot: " + hasDot);
        int lastPointer = n - (hasDot ? 2 : 1);

        //1.字符串先进行整体的翻转
        char[] chrs = inputStr.toCharArray();
        while (firstPointer <= lastPointer) {
            if (DEBUG) {
                System.out.println("firstPointer Index :" + firstPointer + "; lastPointerIndex: " + lastPointer);
            }
            swap(chrs, firstPointer, lastPointer);
            firstPointer++;
            lastPointer--;
        }

        System.out.println("第一次交换元素后的数组内容：");
        for (int i = 0; i < chrs.length; i++) {
            System.out.print("" + chrs[i]);
        }
        //god a ma I.
        //2.再把从局部把当个单词进行反转
        System.out.println(" ");
        firstPointer = 0;
        lastPointer = 0;
        while (lastPointer < n - (hasDot ? 2 : 1)) {
            if (chrs[lastPointer] != ' ') {
                lastPointer++;
            } else {
                //lastPointer遇到一个空格，则发现一个单词，开始交换
                int temp = lastPointer - 1;
                while (firstPointer <= temp) {
                    swap(chrs, firstPointer, temp);
                    temp--;
                    firstPointer++;
                }
                firstPointer = lastPointer + 1;
                lastPointer++;
            }

        }
        System.out.println("");
        System.out.println("第二次交换元素后的数组内容,即最终结果： ");
        for (int i = 0; i < chrs.length; i++) {
            System.out.print("" + chrs[i]);
        }
        return result;
    }

    private static void swap(char[] chrs, int firstPointer, int lastPointer) {
        char temp = chrs[firstPointer];
        chrs[firstPointer] = chrs[lastPointer];
        chrs[lastPointer] = temp;
    }
}
