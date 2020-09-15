package com.company.arraytest;

import java.lang.reflect.Array;

public class ArrayTest1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class cl = Class.forName("java.lang.String");

        Object array = Array.newInstance(cl,10);
        Array.set(array,5,"hello");
        String str = (String) Array.get(array, 5);
        System.out.println(str);
    }
}
