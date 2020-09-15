package com.company.privatetest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class InvokePrivate {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        PrivateTest privateTest = new PrivateTest();
        Class cl = privateTest.getClass();
        //getMethod只能返回public方法
        Method method = cl.getDeclaredMethod("sayHello",String.class);
        method.setAccessible(true);
        Object object = method.invoke(privateTest,"hehe");
        System.out.println(object);
    }
}
