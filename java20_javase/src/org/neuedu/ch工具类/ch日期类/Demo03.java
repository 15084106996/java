package org.neuedu.ch工具类.ch日期类;

import java.util.Calendar;

public class Demo03 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        calendar.set(2007,7,8,12,13,14);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH)+1);
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.HOUR));// 12进制
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));// 24进制
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));// 1周日-7周六
    }
}
