package org.neuedu.ch集合.homework;

import java.util.UUID;

public class Practice09 {
    public static void main(String[] args) {
        // 编写一个方法为物品生成一个指定长度的编号，要求编号的每一位或者为0到9的数字，
        // 或者为A到Z的大写字母，每次产生的编号是随机的
        // 16位
        String str = "";
        for (int i = 0; i < 16; i++) {
            double random = Math.random();
            if (random < 0.5) {
                int num = (int)(Math.random()*10);
                str += num;
            }else{
                char aChar = (char)(Math.random() * 26 + 65);
                str += aChar;
            }
        }
        System.out.println(str);
    }
}
