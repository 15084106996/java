package org.neuedu.ch集合.demo08;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo02 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("java1", 12);
        map.put("java2", 22);
        map.put("java3", 32);
        map.put("java4", 42);

        Set<String> set = map.keySet();

        // key 遍历
        for (String key : map.keySet()) {
            System.out.println(key+","+map.get(key));
        }

        // entry 遍历
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+","+entry.getValue());
        }
    }
}
