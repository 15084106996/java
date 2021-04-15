package org.neuedu.ch面向对象.继承.demo05;

public class Child extends Parent{
    int num = 300;

    public Child() {
        super();
    }

    @Override
    public void add() {
        num = num + 200;
        System.out.println(num);// 200
    }
}
