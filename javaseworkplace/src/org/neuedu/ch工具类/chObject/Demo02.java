package org.neuedu.ch工具类.chObject;

public class Demo02 {
    int id;

    @Override
    public boolean equals(Object obj) {
        Demo02 d = (Demo02) obj;
        return this.id == d.id;
    }

    public static void main(String[] args) {
        Demo02 d1 = new Demo02();
        d1.id = 100;
        Demo02 d2 = new Demo02();
        d2.id = 100;

        System.out.println(d1 == d2);// false
        System.out.println(d1.equals(d2));// false

//        int x = 5;
//        int y = 6;
//        System.out.println(x == y);//false
//        System.out.println(x.equals(y));
    }
}
