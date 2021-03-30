package org.neuedu.ch集合.demo01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("hello");
        list.add(1);
        list.add(true);
        list.add("hello");
        System.out.println(list);
        System.out.println(list.get(2));

        LinkedList list2 = new LinkedList();
        list2.add("hello");
        list2.add(1);
        list2.add(true);
        list2.add("hello");
        System.out.println(list2);
        System.out.println(list2.get(2));

    }
}
