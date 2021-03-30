package org.neuedu.ch面向对象.多态.practice05;

public class Test {
    public static void main(String[] args) {
        Parking p = new Parking();
        Car car = new Car(2);
        Truck truck = new Truck(2);
        Bus bus = new Bus(2);

        p.getMoney(car);
        p.getMoney(truck);
        p.getMoney(bus);
    }
}
