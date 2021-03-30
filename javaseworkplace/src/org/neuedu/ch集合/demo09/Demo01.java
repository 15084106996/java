package org.neuedu.ch集合.demo09;

import java.util.*;

public class Demo01 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("hello1");
        set.add("hello2");
        set.add("hello3");
        set.add("hello4");

        // 获取迭代器对象
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }
}
