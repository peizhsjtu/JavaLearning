package com.java.lang.Throwable;

import java.util.Objects;

/**
 * 编译看左边，运行看右边：Animal c = new Cat(); 左边是baidu Animal 类(或接口) 右边是 Cat()类； 在编译zhi的时候编译器不管dao你右边是什么类，只属要左边的Animal类(或接口)能编译通过就不会报错。但是运行的时候就要按照右边的Cat()类实际情况来运行。
 */
public class ThrowableTest1 {
    public static void main(String[] args) {
        System.out.println(Objects.equals("lihua","lihua"));
        Object a = "abc";
        System.out.println(a.toString()+" : " + a.equals("abc"));
    }
}
