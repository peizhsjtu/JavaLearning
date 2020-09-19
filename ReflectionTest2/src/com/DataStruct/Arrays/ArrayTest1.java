package com.DataStruct.Arrays;

import java.util.Arrays;

public class ArrayTest1 {
    public static void main(String[] args) {
        String[] str = {"z" , "a" ,"g", "e","c", "x"};
        Arrays.sort(str, (String s1,String s2) ->s2.compareTo(s1));
        //Arrays.sort(str);
        for(String s:str){
            System.out.println(s);
        }

        System.out.println("--------------------------------------");

        Integer[] num = {10, 5, 2, 7, 8, 4, 2};
        Arrays.sort(num, (Integer i1, Integer i2) -> i2-i1);
        for(Integer element : num){
            System.out.println(element);
        }

        System.out.println("--------------------------------------");

        System.out.println(Arrays.binarySearch(num, 8));

    }

}
