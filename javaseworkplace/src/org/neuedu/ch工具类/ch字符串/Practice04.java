package org.neuedu.ch工具类.ch字符串;

public class Practice04 {
    public static boolean getNum(int num) {
        // 如果num是由 1,2,2,3,4,5 组成，返回true
        String str = num + "";
        String[] arr = {"1", "2", "3", "4", "5"};
        for (String s : arr) {
            if (!str.contains(s)) {
                return false;
            }
        }

        if (str.indexOf("2") == str.lastIndexOf("2")) {
            return false;
        }

        if (str.charAt(3) == '4') {
            return false;
        }

        if (str.contains("35") || str.contains("53")) {
            return false;
        }

        return true;
    }
    public static void main(String[] args) {
        // 1,2,2,3,4,5,打印出这6个数，组成的所有6位数字
        // 4不能是百位
        // 3和5不能相邻
        for (int i = 122345; i <= 543221 ; i++) {
            if (getNum(i)) {
                System.out.println(i);
            }
        }
    }
}
