package org.neuedu.ch集合.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Practice10 {

    public static boolean checkDate() {
        // 编写一个方法验证用户输入的日期格式是否正确，要求格式为：2006/12/12。
        // 方法的参数是要验证的日期字符串，如果格式正确返回true，否则返回false
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入");
        String strDate = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            sdf.parse(strDate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(checkDate());
    }
}
