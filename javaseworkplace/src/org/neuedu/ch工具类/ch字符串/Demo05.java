package org.neuedu.ch工具类.ch字符串;

public class Demo05 {
    public static void main(String[] args) {
        StringBuilder sbf = new StringBuilder("hello");
        String str1 = sbf.toString();
//        sbf.append(" world");
//        System.out.println(sbf);
//        sbf.reverse();
//        System.out.println(sbf);

        StringBuilder sbf1 = new StringBuilder("hello");
        String str2 = sbf1.toString();
        System.out.println(sbf1.equals(sbf));// false
        System.out.println(str1.equals(str2));// false
        System.out.println(sbf.toString().equals(sbf1.toString()));// true
    }
}
