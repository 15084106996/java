package org.neuedu.ch面向对象.statics.singleton;

public class Singleton {

    private static Singleton s;
    private Singleton(){}
    public static Singleton getInstance(){
        if (s == null) {
            s = new Singleton();
        }
        return s;
    }

    public void test() {
        System.out.println(123);
    }


//    private static Singleton s = new Singleton();
//    private Singleton(){}
//    public static Singleton getInstance(){
//        return s;
//    }
}
