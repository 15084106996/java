package org.neuedu.ch集合.demo07;

import java.util.TreeSet;

public class Demo01 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet(new Student());
        Student s1 = new Student("tom",26);
        Student s2 = new Student("bob",24);
        Student s3 = new Student("ella",23);
        set.add(s1);
        set.add(s2);
        set.add(s3);
        System.out.println(set);
    }
}
