package org.neuedu.ch类和对象.practice03;

public class Point {
    int x;
    int y;

    public void movePoint(int dx,int dy) {
        this.x = dx;
        this.y = dy;
        System.out.println(x+","+y);
    }

    public Point(int x0, int y0) {
        this.x = x0;
        this.y = y0;
    }

    public Point() {
    }
}
