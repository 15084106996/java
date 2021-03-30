package org.neuedu.ch类和对象.demo10;

public class Demo01 {
    public void getX(int x) {
        x = x * 3;
    }
    public void getY(int[] y) {
        y[0] = y[0] * 3;
    }
    public static void main(String[] args) {
        Demo01 d = new Demo01();
        int x = 10;
        int[] y = {10};
        d.getX(x);
        System.out.println(x);// 10

        d.getY(y);
        System.out.println(y[0]);// 30
    }
}
