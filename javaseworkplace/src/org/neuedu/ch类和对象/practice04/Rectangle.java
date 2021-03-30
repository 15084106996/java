package org.neuedu.ch类和对象.practice04;

public class Rectangle {
    double width;
    double height;
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getArea() {
        return width * height;
    }
    public double getPer() {
        return (width + height) * 2;
    }
    public void showAll() {
        System.out.println("长:"+this.width);
        System.out.println("高:"+this.height);
        double area = getArea();
        System.out.println("面积:"+area);
        double per = getPer();
        System.out.println("周长:"+per);
    }
    public static void main(String[] args) {
        Rectangle r = new Rectangle(3,5);
        r.showAll();
    }
}
