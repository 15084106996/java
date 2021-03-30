package org.neuedu.ch面向对象.继承.demo05;

public class Parent {
    int num = 100;

    public Parent() {
        add();
    }

    public void add() {
        num = num + 100;
        System.out.println(num);
    }
}
