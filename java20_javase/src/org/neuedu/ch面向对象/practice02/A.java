package org.neuedu.ch面向对象.practice02;

public class A {
    public void show1() {
        B b = new B();
        b.test();
    }
    public void show2(B b) {
        b.test();
    }

    public static void main(String[] args) {
        A a = new A();
        a.show1();

        B b = new B();
        b.name = "tom";
        a.show2(b);
    }
}
