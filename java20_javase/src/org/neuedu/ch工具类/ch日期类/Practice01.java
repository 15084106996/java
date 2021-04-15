package org.neuedu.ch工具类.ch日期类;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Practice01 {
    public static void main(String[] args) {
        Date date1 = null;
        Date date2 = null;
        try {
            String str1 = "2001-9-3";
            String str2 = "2020-3-5";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date1 = sdf.parse(str1);
            date2 = sdf.parse(str2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long between = date2.getTime() - date1.getTime();
        System.out.println(between/1000/3600/24);
    }
}
