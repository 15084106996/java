package org.neuedu.ch集合.homework;

import java.util.Scanner;

public class Practice12 {
    public static void main(String[] args) {
        // 输入一行字符，将其中的字母变成其后续的第3个字母，输出。例：a→d，x　→　a；y　→　b；编程实现
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入");
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (aChar + 3 <= 122) {
                System.out.print((char)(aChar + 3));
            }else {
                System.out.print((char)((aChar + 3) % 122 + 96));
            }
        }
    }
}
