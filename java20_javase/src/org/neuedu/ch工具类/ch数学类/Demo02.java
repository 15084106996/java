package org.neuedu.ch工具类.ch数学类;

import java.util.Random;

public class Demo02 {
    public static void main(String[] args) {
        // 1-100
        int random = (int)(Math.random()*100+1);// [1,101)

        // Random 类
        Random r = new Random();
        int num = r.nextInt(100)+1;// [1,101)
        System.out.println(num);
    }
}
