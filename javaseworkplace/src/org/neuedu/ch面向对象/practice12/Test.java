package org.neuedu.ch面向对象.practice12;

public class Test {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("benz","black");
        vehicle.run();

        Car car = new Car("Honda", "red", 2);
        car.run();
        car.run();

        new Car("Honda", "red", 2).run();
        new Car("Honda", "red", 2).run();
    }
}
