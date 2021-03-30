package org.neuedu.ch面向对象.多态.practice04;

public class Test {
    public static void main(String[] args) {
        Parking p = new Parking();
        Vehicle car = new Car();
        Vehicle truck = new Truck();
        Vehicle bus = new Bus();

        p.getMoney(car,0.5);
        p.getMoney(truck,0.5);
        p.getMoney(bus,0.5);
    }
}
