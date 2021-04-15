package org.neuedu.ch类和对象.demo06;

public class StudentTest {
    public static void main(String[] args) {
        Student s1 = new Student("tom",22);
        System.out.println(s1);// 包名类名@哈希值
        System.out.println(s1.getName());

        Student s2 = s1.getStu();
        System.out.println(s2);
        System.out.println(s2.getName());
        System.out.println(s1.getStu().getName());
    }
}
