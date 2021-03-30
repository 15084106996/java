package org.neuedu.ch面向对象.多态.practice04;

public class Truck extends Vehicle {
    @Override
    public double payMoney(double times) {
        return times*12;
    }
}
