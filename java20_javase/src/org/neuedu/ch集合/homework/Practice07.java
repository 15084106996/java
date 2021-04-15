package org.neuedu.ch集合.homework;

import java.util.Scanner;

public class Practice07 {
    public static void main(String[] args) {
        // 有一个字符串，其中包含中文字符、英文字符和数字字符，请统计和打印出各个字符的个数
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入");
        String str = scanner.nextLine();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (aChar >= '0' && aChar <= '9') {
                count3++;
            } else if (aChar >= 'a' && aChar <= 'z' || aChar >= 'A' && aChar <= 'Z') {
                count2++;
            }else{
                count1++;
            }
        }

        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);
    }
}
