package org.neuedu.ch面向对象.继承.demo03;

public class Child extends Parent{
    public Child() {
        System.out.println(1);
    }
    @Override
    public void test() {
        System.out.println("b");
    }
}
