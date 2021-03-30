package org.neuedu.ch面向对象.多态.practice04;

public class Bus extends Vehicle {
    @Override
    public double payMoney(double times) {
        return 15*times;
    }
}
