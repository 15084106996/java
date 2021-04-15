package org.neuedu.ch面向对象.多态.practice03;

public class ZuiFan extends Person {
    @Override
    public void buyTicket(double price) {
        System.out.println("打骨折");
    }
}
