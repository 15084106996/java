package org.neuedu.ch工具类.ch字符串;

public class Demo02 {
    public static void main(String[] args) {
        String str1 = "hello";
        // public int length() 返回长度
        System.out.println(str1.length());// 5

        // public String substring(int begin) 从起始索引截取
        // public String substring(int begin,int end) 从起始索引，截取到结束索引之前
        System.out.println(str1.substring(1));// ello
        System.out.println(str1.substring(1,4)); // ell

        // public int indexOf(String str) 返回 参数 在原有字符串中 第一次 出现的位置
        System.out.println(str1.indexOf("l"));// 2
        // public int lastIndexOf(String str) 返回 参数 在原有字符串中 最后一次 出现的位置
        System.out.println(str1.lastIndexOf("l"));// 3
    }
}
