package org.neuedu.ch面向对象.多态.demo03;

public class Test {
    public static void main(String[] args) {
        Role w1 = new Warrior("盖伦");
        Role m1 = new Master("张海柱");

        w1.pk(m1);
        m1.pk(w1);
    }
}
