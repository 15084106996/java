package org.neuedu.ch面向对象.多态.practice03;

public class Teacher extends Person {
    @Override
    public void buyTicket(double price) {
        System.out.println(price*0.9);
    }
}
