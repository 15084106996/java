package org.neuedu.ch工具类.ch日期类;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo06 {
    public static void main(String[] args) {
        Date date = new Date();
        // yyyy  完整的年份
        // MM 数字月份
        // dd 日期
        // HH/hh 24进制/12进制
        // mm 分钟
        // ss 秒
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(date);
        System.out.println(str);

        String str1 = "2020-11-03 12:13:14";
        try {
            Date date1 = sdf.parse(str1);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
