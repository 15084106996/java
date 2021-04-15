package org.neuedu.ch集合.demo03;

import java.util.ArrayList;
import java.util.List;

public class Demo03 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        for (int i = 0; i < list.size(); i++) {
            int o = (int)(list.get(i));
            System.out.println(o+1);
        }
    }
}
