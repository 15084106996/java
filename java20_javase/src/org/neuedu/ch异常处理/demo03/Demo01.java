package org.neuedu.ch异常处理.demo03;

public class Demo01 {

    public int getNum() {
        try {
            System.out.println(5 / 0);
            return 2;
        } catch (Exception e) {
            return 3;
        }finally {
            return 4;
        }
    }

    public static void main(String[] args) {
        try {
            Class.forName("org.neuedu.ch异常处理.demo03.Demo01");
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println(123);
        }

    }
}
