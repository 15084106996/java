package org.neuedu.ch工具类.ch日期类;

import java.util.Calendar;

public class Demo05 {
    public static void main(String[] args) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2008,7,8,12,13,14);

        Calendar calendar2 = Calendar.getInstance();
        if (calendar1.before(calendar2)) {
            System.out.println("第1个日期早");
        }else{
            System.out.println("第2个日期早");
        }
        if (calendar2.after(calendar1)) {
            System.out.println("第1个日期早");
        }else{
            System.out.println("第2个日期早");
        }
    }
}
