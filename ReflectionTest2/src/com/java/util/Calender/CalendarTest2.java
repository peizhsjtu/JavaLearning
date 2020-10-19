package com.java.util.Calender;

import java.util.Locale;
import java.util.TimeZone;

public class CalendarTest2 {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        locale.getCountry();
        locale.getLanguage();
        System.out.println("default locale is "+locale);
        System.out.println("default country is "+locale.getCountry());
        System.out.println("default language is "+locale.getLanguage());

        TimeZone timeZone = TimeZone.getDefault();
        System.out.println("default time zone is "+ timeZone.getDisplayName());
    }
}
