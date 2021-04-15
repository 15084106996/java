package org.neuedu.ch工具类.ch包装类;

public class Demo02 {
    public static void main(String[] args) {
        String price = "400";
        System.out.println(price+100);
        int numPrice = Integer.valueOf(price);// Integer
        int numPrice3 = Integer.parseInt(price);// int
        System.out.println(numPrice+100);
        double numPrice2 = Double.valueOf(price);// Double
        double numPrice4 = Double.parseDouble(price);// double
        System.out.println(numPrice2+100);

        int num = 100;
        String str1 = num + "";
        String str2 = String.valueOf(num);
        String str3 = Integer.toString(num);
    }
}
