package com.java.util.Calender;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest {
    public static void main(String[] args) {


        DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT, Locale.SIMPLIFIED_CHINESE);
        DateFormat format2 = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.SIMPLIFIED_CHINESE);
        DateFormat format3 = DateFormat.getDateInstance(DateFormat.LONG, Locale.SIMPLIFIED_CHINESE);

        DateFormat format4 = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ENGLISH);
        DateFormat format5 = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.ENGLISH);
        DateFormat format6 = DateFormat.getDateInstance(DateFormat.LONG, Locale.ENGLISH);

        try {
            System.out.println("format : " + format.format(new Date()));
            System.out.println("format2 : " + format2.format(new Date()));
            System.out.println("format3 : " + format3.format(new Date()));
            System.out.println("format4 : " + format4.format(new Date()));
            System.out.println("format5 : " + format5.format(new Date()));
            System.out.println("format6 : " + format6.format(new Date()));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
