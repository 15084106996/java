package org.neuedu.ch面向对象.多态.practice05;

public class Bus extends Vehicle {
    public Bus(double times) {
        this.times = times;
    }

    @Override
    public double payMoney() {
        return 15*times;
    }
}
