package com.company.privatetest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokePrivate2 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        PrivateTest2 privateTest2 = new PrivateTest2();
        Class cl = privateTest2.getClass();
        Field field = cl.getDeclaredField("name");
        field.setAccessible(true);
        field.set(privateTest2, "lisi");

        Method method = cl.getMethod("getName");
        Object obj = method.invoke(privateTest2);
        System.out.println(obj);
    }
}
