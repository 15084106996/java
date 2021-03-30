package org.neuedu.ch面向对象.practice12;

public class Car extends Vehicle {
    int loader;

    public Car(String brand, String color, int loader) {
        super(brand, color);
        this.loader = loader;
    }

    @Override
    public void run() {
        System.out.println(getBrand()+"自由是方向");
    }
}
