package org.neuedu.ch类和对象.demo06;

public class StudentTest {
    public static void main(String[] args) {
        Student s1=new Student("Tom",22);
        System.out.println(s1);
        Student s2=s1.getStu();
        System.out.println(s2);
        System.out.println(s2.getName());
    }
}
