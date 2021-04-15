package org.neuedu.ch类和对象.demo02;

public class StudentTest {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("bob");

        Student s2 = new Student();
        s2.setName("tom");

        s2.pk(s1);
    }
}
