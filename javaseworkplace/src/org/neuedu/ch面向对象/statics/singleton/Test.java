package org.neuedu.ch面向对象.statics.singleton;

public class Test {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        s.test();
    }
}
