package org.neuedu.ch面向对象.多态.practice04;

public class Car extends Vehicle {
    @Override
    public double payMoney(double times) {
        return times * 8;
    }
}
