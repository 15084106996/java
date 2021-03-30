package org.neuedu.ch面向对象.statics.demo03;

public class Demo01 {
    int num1;
    static int num2;
    public static void test1() {
        System.out.println(num2);
    }

    public void test2() {
        System.out.println(num1);
        System.out.println(num2);
    }

    public static void main(String[] args) {
        test1();
        System.out.println(num2);
    }
}
