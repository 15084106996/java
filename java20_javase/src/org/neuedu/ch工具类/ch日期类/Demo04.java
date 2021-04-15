package org.neuedu.ch工具类.ch日期类;

import java.util.Calendar;

public class Demo04 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR,1);
        System.out.println(calendar.get(Calendar.YEAR));
    }
}
