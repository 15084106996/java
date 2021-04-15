package org.neuedu.ch周测练习;

public class Demo01 {
    public static void main(String[] args) {
        String str = "11,dgf,23,的风格,0,77";
        String[] split = str.split(",");
        int sum = 0;
        for (String s : split) {
            try {
                int num = Integer.valueOf(s);
                sum = sum + num;
            } catch (Exception e) {}
        }
        System.out.println(sum);
    }
}
