package Strings;

public class LeftRotationString {
    public static String reverseLeftWords(String s, int n) {
        int slow = 0;
        int fast = n;
        StringBuilder beforeResult = new StringBuilder();
        StringBuilder afterResult = new StringBuilder();

        char[] chars = s.toCharArray();
        while (fast < s.length()) {
            beforeResult.append(chars[fast++]);
        }
        while (slow < n) {
            afterResult.append(chars[slow++]);
        }
        return beforeResult.toString() + afterResult.toString();
    }

    //先从数组内部的小区间旋转，再外部旋转
    public static String reverseLeftWords2(String s, int n) {
        int leftStart = 0;
        int leftEnd = n - 1;

        int rightStart = n;
        int rightEnd = s.length() - 1;
        char[] chars  = s.toCharArray();

        swap(chars, leftStart, leftEnd);
        //abcdefg
        //bacdefg

        swap(chars, rightStart, rightEnd);
        //bacdefg
        //bagfedc

        swap(chars, 0, chars.length - 1);
        //bagfedc
        //cdefgab

        return String.copyValueOf(chars);
    }

    private static void swap(char[] chars, int left, int right) {
        while (right > left) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        String s2 = "ab";
        String s3 = "lrloseumgh";
        System.out.print(reverseLeftWords2(s3, 6));
    }


}
