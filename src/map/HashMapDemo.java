package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("qiang",29);
        map.put("wu",31);
        map.put("li",11);
        //遍历map的方法
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println("entry : key = " + entry.getKey() +" value = " +entry.getValue());
        }

        Set<String> keyset = map.keySet();
        for (String key : keyset) {
           System.out.println("key = " + key +" value = " + map.get(key));
        }


    }

}
