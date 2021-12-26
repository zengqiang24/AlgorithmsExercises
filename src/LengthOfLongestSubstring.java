import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.print(LengthOfLongestSubstring("dvdf"));
    }

    public static int LengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = 0, res = 0;
        for(int j = 0; j < s.length(); j++) {
            if(dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j)) + 1); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i + 1); // 更新结果
        }
        return res;
    }
}
