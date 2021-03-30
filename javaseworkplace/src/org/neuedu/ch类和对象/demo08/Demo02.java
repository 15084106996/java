package org.neuedu.ch类和对象.demo08;

public class Demo02 {
    public void test() {
        System.out.println("hello");
    }
    public static void main(String[] args) {
        Demo02 d = new Demo02();
        d.test();
        d.test();

        // 匿名对象
        new Demo02().test();
        new Demo02().test();
    }
}
