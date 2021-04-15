package org.neuedu.ch工具类.ch包装类;

public class Demo01 {
    public static void main(String[] args) {
        Integer num1 = 127;
        Integer num2 = 127;
        System.out.println(num1 == num2);// true

        Integer num3 = new Integer(128);
        Integer num4 = new Integer(128);
        System.out.println(num3 == num4);// false
    }
}
