package org.neuedu.ch集合.demo03;

import java.util.ArrayList;
import java.util.List;

public class Demo04 {
    public static void main(String[] args) {
        // 泛型
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for (Integer num : list) {
            System.out.println(num);
        }

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
        }
    }
}
