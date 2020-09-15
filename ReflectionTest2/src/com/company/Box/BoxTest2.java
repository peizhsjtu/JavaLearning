package com.company.Box;

import java.sql.SQLOutput;

/**
 * Integer类有一个缓存，他会缓存介于-128~127之间的整数.如果直接赋值(valueOf有缓存对象)，则不会生成新对象，如果通过构造函数赋值，则其不带缓存的，会生成新对象。
 */
public class BoxTest2 {
    public static void main(String[] args) {

        Integer i1 = 100;
        Integer i2 = 100;
        System.out.println(i1 == i2 ? "i1 == i2" : "i1 != i2");
        System.out.println("-----------------");

        Integer i3 = 200;
        Integer i4 = 200;
        System.out.println(i3 == i4? "i3 == i4" : "i3 != i4");
    }
}
