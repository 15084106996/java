package org.neuedu.ch类和对象.demo09;

public class Demo02 {
    public void test1(){
        test2();
        Demo03 d = new Demo03();
        d.aaa();
    }

    public void test2() {

    }

    public static void main(String[] args) {
        Demo02 d = new Demo02();
        d.test1();

    }
}
