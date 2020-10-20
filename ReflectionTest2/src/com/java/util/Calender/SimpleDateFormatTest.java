package com.java.util.Calender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventListener;

public class SimpleDateFormatTest {
    public static void main(String[] args) {
        String dateString = "2013-02-12T12:22:33";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        System.out.println("simpleDate format " + simpleDateFormat.format(new Date()));
        try {
            System.out.println("simpleDate parse "+ simpleDateFormat.parse(dateString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
