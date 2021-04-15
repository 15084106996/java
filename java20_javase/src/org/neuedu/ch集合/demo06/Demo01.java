package org.neuedu.ch集合.demo06;

import java.util.HashSet;
import java.util.Set;

public class Demo01 {
    public static void main(String[] args) {
//        Set set = new HashSet();
//        set.add(1);
//        set.add("hello");
//        set.add(true);
//        set.add(9.9);
//        set.add(new Demo01());
//        set.add("hello");
//
//        System.out.println(set);
//        System.out.println(set.size());
//        System.out.println(set.contains("hello"));
//        System.out.println(set.remove(1));
        Set<String> set = new HashSet<>();
        set.add("hello");
        for (String s : set) {
            System.out.println(s);
        }
    }
}
