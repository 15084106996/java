package org.neuedu.ch面向对象.多态.practice05;

public class Car extends Vehicle {
    public Car(double times) {
        this.times = times;
    }
    @Override
    public double payMoney() {
        return times * 8;
    }
}
