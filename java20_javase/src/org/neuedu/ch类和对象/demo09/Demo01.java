package org.neuedu.ch类和对象.demo09;

public class Demo01 {
    public void test1() {
        int num = test2();
        System.out.println(1232);
    }

    public int test2() {
        System.out.println(1231);
        return 1;
    }

    public static void main(String[] args) {
        Demo01 d = new Demo01();
        d.test1();
    }
}
