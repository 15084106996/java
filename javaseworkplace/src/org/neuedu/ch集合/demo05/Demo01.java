package org.neuedu.ch集合.demo05;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {

    public static void showInfo(List<Student> list) {
        if (list != null && !list.isEmpty()) {
            for (Student student : list) {
                System.out.println(student);
            }
        }
    }

    public static void main(String[] args) {
        List<Student> list = null;
        showInfo(list);
    }
}
