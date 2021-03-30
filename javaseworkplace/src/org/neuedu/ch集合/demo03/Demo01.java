package org.neuedu.ch集合.demo03;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        System.out.println(list);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(0,0);
        System.out.println(list.get(2));
        list.remove(1);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.contains(4));
    }
}
