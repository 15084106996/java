package org.neuedu.ch面向对象.practice05;

public class ChangFangTi extends Rectangle {
    double height;

    public ChangFangTi(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public ChangFangTi() {}

    public double findVolume() {
        return length * width * height;
    }
}
