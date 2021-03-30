package org.neuedu.ch集合.demo09;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo02 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap();
        map.put("java1",1001);
        map.put("java2",1002);
        map.put("java3",1003);
        map.put("java4",1004);


        Set<String> keys = map.keySet();

        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key+","+map.get(key));
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator1 = entries.iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, Integer> entry = iterator1.next();
            System.out.println(entry.getKey()+","+entry.getValue());
        }
    }
}
