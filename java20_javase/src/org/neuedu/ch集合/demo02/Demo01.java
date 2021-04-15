package org.neuedu.ch集合.demo02;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) {
        // list1 存100个元素.扩容了几次 = 6次
        List list1 = new ArrayList();
        list1.add(1);
        list1.add(3);
        list1.add(1, 2);
        System.out.println(list1);



        // list2  扩容了几次 = 0次
//        List list2 = new ArrayList(100);

    }
}
