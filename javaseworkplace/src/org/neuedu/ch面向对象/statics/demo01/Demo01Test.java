package org.neuedu.ch面向对象.statics.demo01;

public class Demo01Test {
    public static void main(String[] args) {
        Demo01 d = new Demo01();
        d.num = 100;
        d.test1();

        d.num2 = 100;
        d.test2();
        // 静态方法和属性可以直接通过类名进行调用
        Demo01.num2 = 200;
        Demo01.test2();

        double random = Math.random();
    }
}
