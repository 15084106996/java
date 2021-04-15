package org.neuedu.ch异常处理.demo04;

public class Test2 {
    public static void main(String[] args) {
        Demo01 d = new Demo01();
        try {
            d.test();
        } catch (ClassNotFoundException e) {
            System.out.println(222);
        }
    }
}
