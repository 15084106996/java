package org.neuedu.ch工具类.ch字符串;

public class Demo04 {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "Hello";
        // public boolean equals(String str) 比较字符串是否相等
        System.out.println(str1.equals(str2));// false
        // public boolean equalsIgnoreCase(String str) 比较字符串是否相等(忽略大小写)
        System.out.println(str1.equalsIgnoreCase(str2));// true
        // public boolean contains(String str) : 判断字符串是否包含一个子字符串
        System.out.println(str1.contains("ell"));// true
        // public boolean startsWith(String str) : 是否以xx开头
        System.out.println(str1.startsWith("app"));//false
        // public boolean endsWith(String str): 是否以xx结尾
        System.out.println(str1.endsWith("llo"));//true
        // public String concat(String str)
        System.out.println(str1.concat(" world"));
        // public String trim() : 掐头去尾,去掉空格
        System.out.println(" hello   world      ".trim());
    }
}
