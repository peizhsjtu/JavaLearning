package com.java.lang.Class;

import java.io.Serializable;
import java.util.Arrays;

public class ClassTest implements Serializable {
    private String add;


    public static void main(String[] args) {
        System.out.println(Arrays.toString(OuterClass.class.getClasses()));
        System.out.println(Arrays.toString(OuterClass.class.getDeclaredClasses()));

        System.out.println(Arrays.toString(OuterClass.class.getDeclaredFields()));

        System.out.println(Arrays.toString(Class.class.getDeclaredFields()));
    }
}

class OuterClass implements Serializable{

    public class InnerClass1{
        String name1;
    }

    public class InnerClass2{
        String name2;
    }

    public class InnerClass3{
        String name3;
    }

    class InnerClass4{
        String name4;
    }

    private class InnerClass5{
        String name5;
    }
}