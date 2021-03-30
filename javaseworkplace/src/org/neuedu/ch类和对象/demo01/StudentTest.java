package org.neuedu.ch类和对象.demo01;

public class StudentTest {
    public static void main(String[] args) {
        // 基本数据类型
        // 引用数据类型：类，数组，接口
        // 实例化对象（创建对象）
        Student s1 = new Student();
        s1.name = "tom";
        s1.age = 12;
        s1.gender = true;
        System.out.println(s1);

        Student s2 = new Student("tom", 12, true);
        s2.name = "tom2";
        s2.setName("tom3");

        System.out.println(s1 == s2);// false

        // setter修改 and getter访问
        System.out.println(s1.name);
        String name = s1.getName();
        System.out.println(name);
    }
}
