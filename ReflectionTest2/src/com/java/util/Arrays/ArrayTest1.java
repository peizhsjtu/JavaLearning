package com.java.util.Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 　作用是返回由指定数组支持的固定大小列表。
 *
 * 　　注意：这个方法返回的 ArrayList 不是我们常用的集合类 java.util.ArrayList。这里的 ArrayList 是 Arrays 的一个内部类 java.util.Arrays.ArrayList。这个内部类有如下属性和方法
 *
 *
 *
 */
public class ArrayTest1 {
    public static void main(String[] args) {


        Integer[] list = {1, 2};

        Object[] list3 = new Object[4];
        list3[3] = 4;
        list3[2] = 111;
        list3[1] = 1;
        System.out.println(list3.getClass());

        List list2 = Arrays.asList(list);
        Object[] objects = list2.toArray(list3);
        for(Object object:objects){
            System.out.println(object);
        }
    }
}
