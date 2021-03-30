package org.neuedu.ch面向对象.practice05;

public class Rectangle {
    double length;
    double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle() {}

    public double findArea() {
        return length * width;
    }
}
