package org.neuedu.ch面向对象.多态.practice01;

public class Test {
    public static void main(String[] args) {
        int body = 0;// 0-学生 5折，1-教师 9折，2-工人 8折，3-罪犯 骨折
        int body1 = 1;// 0-学生 5折，1-教师 9折，2-工人 8折，3-罪犯 骨折
        int ticket = 100;
        if (body == 0) {
            System.out.println(ticket*0.5);
        }
    }
}
