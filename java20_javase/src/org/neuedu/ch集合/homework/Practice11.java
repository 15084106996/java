package org.neuedu.ch集合.homework;

import java.util.Scanner;

public class Practice11 {
    public static void main(String[] args) {
        // 由键盘输入的任意一组字符，统计其中大写字母的个数m和小写字母的个数n，并输出m、n中的较大者
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入");
        String str = scanner.nextLine();
        int m = 0;
        int n = 0;
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (aChar >= 65 && aChar <= 90) {
                m++;
            } else if (aChar >= 97 && aChar <= 122) {
                n++;
            }
        }

        System.out.println(Math.max(m, n));
    }
}
