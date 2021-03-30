package org.neuedu.ch面向对象.practice08;

public class PolyTester {
    public static void main(String[] args) {
        SuperClass subClassA = new SubClassA();
        SuperClass subClassB = new SubClassB();
        subClassA.display();
        subClassB.display();
    }
}
