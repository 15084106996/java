package org.neuedu.ch工具类.ch字符串;

import java.util.Arrays;

public class Demo03 {
    public static void main(String[] args) {
        String str1 = "hello";
        // publi char charAt(int index) 返回 指定 索引处的字符
        System.out.println(str1.charAt(4));
        // public char[] toCharArray() 返回字符串的字符数组
        char[] arr = str1.toCharArray(); // {'h','e','l','l','o'}
        System.out.println(Arrays.toString(arr));
        // public String[] spilt(String str) 将字符串按照参数分割成一个数组
        String str2 = "辽宁^湖北^新疆";
        String[] strArr = str2.split("\\^");
        System.out.println(Arrays.toString(strArr));
    }
}
