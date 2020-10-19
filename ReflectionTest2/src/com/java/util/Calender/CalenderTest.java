package com.java.util.Calender;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalenderTest {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        Date now = c.getTime();
        System.out.println("当前时间:" + format(c.getTime()));

        // 下个月今天
        c.setTime(now);
        c.add(Calendar.MONTH, 1);
        System.out.println("下个月今天:" + format(c.getTime()));

        // 上年的今天
        c.setTime(now);
        c.add(Calendar.YEAR, -1);
        System.out.println("上年的今天：" + format(c.getTime()));

        // 上个月的第三天
        c.setTime(now);
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DATE, 3);
        System.out.println("上个月的第三天：" + format(c.getTime()));

        // 今天之后8天的日期
        c.setTime(now);
        c.add(Calendar.DATE, 8);
        System.out.println("向后推迟8天的日期：" + format(c.getTime()));

        // 下个月的倒数第三天
        c.setTime(now);
        c.add(Calendar.MONTH, 2);
        c.set(Calendar.DATE, -2);
        System.out.println("下月的倒数第三天："+sdf.format(c.getTime()));
    }

    private static String format(Date date) {
        return sdf.format(date);
    }
}
