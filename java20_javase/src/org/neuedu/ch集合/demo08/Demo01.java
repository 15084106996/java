package org.neuedu.ch集合.demo08;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {
    public static void main(String[] args) {
        Map map = new HashMap();
        // 添加元素
        map.put("a",1001);
        map.put(1002,1001);
        map.put(true,9.9);
        map.put("a",2000);
        Object num = map.get(true);
        System.out.println(num);
        System.out.println(map.size());

    }
}
