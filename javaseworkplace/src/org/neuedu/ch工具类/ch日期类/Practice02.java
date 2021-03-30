package org.neuedu.ch工具类.ch日期类;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Practice02 {

    public static int getWeek(Calendar calendar) {
        int num = calendar.get(Calendar.DAY_OF_WEEK);
        if (num == 1) {
            return 7;
        }else{
            return num - 1;
        }
    }

    public static void main(String[] args) throws ParseException {
        // 周一到周日上下午
        // 1 - 需要上班
        // 0 - 没班
        String rules = "11111111110000";
        Scanner scanner = new Scanner(System.in);
        System.out.println("起始日期");// 2021-1-13
        String str1 = scanner.nextLine();
        System.out.println("结束日期");// 2021-2-4
        String str2 = scanner.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse(str1);
        Date date2 = sdf.parse(str2);

        Calendar begin = Calendar.getInstance();
        begin.setTime(date1);
        Calendar end = Calendar.getInstance();
        end.setTime(date2);
        end.add(Calendar.DATE, 1);

        while (begin.before(end)) {
            // 判断 begin 是周几
            int week = getWeek(begin);
            // 根据 周几 和 rules 决定 打印上班还是打印休息
            int year = begin.get(Calendar.YEAR);
            int month = begin.get(Calendar.MONTH) + 1;
            int date = begin.get(Calendar.DATE);
            String strDate = year + "-" + month + "-" + date;
            if (rules.charAt(2 * week - 2) == '1') {
                System.out.println(strDate+" 上午上班");
            }else{
                System.out.println(strDate+" 上午休息");
            }
            if (rules.charAt(2 * week - 1) == '1') {
                System.out.println(strDate+" 下午上班");
            }else{
                System.out.println(strDate+" 下午休息");
            }
            begin.add(Calendar.DATE, 1);
        }
    }
}
