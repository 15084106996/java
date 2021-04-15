package org.neuedu.ch集合.homework;

import java.util.Scanner;

public class Practice08 {
    public static void main(String[] args) {
        // 有一种数叫回文数，正读和反读都一样，如12321便是一个回文数。
        // 编写一个程序，从命令行得到一个整数，判断该数是不是回文数
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入");
        String str = scanner.nextLine();

        StringBuffer sbf = new StringBuffer(str);

        if (sbf.reverse().toString().equals(str)) {
            System.out.println("回文数");
        }else{
            System.out.println("不是");
        }
    }
}
