package org.neuedu.ch面向对象.多态.demo05;

public class Test {
    public static void main(String[] args) {
        Warrior w1 = new Warrior();
        Master m1 = new Master();
        w1.pk(m1);// 攻击法师
    }
}
