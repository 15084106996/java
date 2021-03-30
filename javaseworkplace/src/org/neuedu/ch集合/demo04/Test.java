package org.neuedu.ch集合.demo04;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student s1 = new Student("tom",22);
        Student s2 = new Student("lucy",23);
        Student s3 = new Student("ella",24);
        Student s4 = new Student("bob",25);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        for (Student student : list) {
            if (student.getAge() > 23) {
                System.out.println(student.getName());
            }
        }
    }
}
