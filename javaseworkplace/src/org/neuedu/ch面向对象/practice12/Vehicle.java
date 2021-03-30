package org.neuedu.ch面向对象.practice12;

public class Vehicle {
    private String brand;
    private String color;
    private double speed;

    public void run() {
        System.out.println("奔跑");
    }

    public Vehicle() {}

    public Vehicle(String brand, String color) {
        this.brand = brand;
        this.color = color;
        this.speed = 0;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
