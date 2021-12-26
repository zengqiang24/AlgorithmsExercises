package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap();
        for (int i = 0; i < 100; i++) {
            hashMap.put("NO."+i,"Value :"+i);
        }
//        for (String s : hashMap.keySet()) {
//            System.out.println(s);
//        }

        for (Map.Entry<String, String> stringStringEntry : hashMap.entrySet()) {
            System.out.println("NO."+stringStringEntry.getKey()+"Value :"+ stringStringEntry.getValue());
        }


    }
}
