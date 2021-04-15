package org.neuedu.ch集合.demo03;

public class Demo05<E> {
    E x;

    public static void main(String[] args) {
        Demo05<String> d1 = new Demo05();
        d1.x = "hello";

        Demo05<Integer> d2 = new Demo05();
        d2.x = 100;

        Demo05 d3 = new Demo05();
        d3.x = true;
    }
}
