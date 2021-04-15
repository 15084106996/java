package org.neuedu.ch面向对象.多态.practice05;

public class Truck extends Vehicle {
    public Truck(double times) {
        this.times = times;
    }

    @Override
    public double payMoney() {
        return times*12;
    }
}
