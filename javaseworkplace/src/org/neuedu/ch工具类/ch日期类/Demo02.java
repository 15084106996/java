package org.neuedu.ch工具类.ch日期类;

import java.util.Calendar;
import java.util.Date;

public class Demo02 {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        Date date = calendar.getTime();
        System.out.println(date);
        System.out.println(date.getTime());
        System.out.println(calendar.getTime().getTime());
    }
}
