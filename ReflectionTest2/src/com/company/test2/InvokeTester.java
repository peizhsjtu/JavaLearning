package com.company.test2;

import java.lang.reflect.Method;

public class InvokeTester {
    public int add(int param1, int param2){
        return param1 + param2;
    }

    public String echo(String message){
        return "hello: " + message;
    }

    public static void main(String[] args) throws Exception{
        Class cl = InvokeTester.class;
        Object invokeTester = cl.newInstance();
        System.out.println(invokeTester instanceof InvokeTester);
        Method addMethod = cl.getMethod("add",int.class,int.class);
        Object result = addMethod.invoke(invokeTester,1,2);
        System.out.println(result);
        System.out.println("*******************");
        Method echoMethod = cl.getMethod("echo",String.class);
        Object result2 = echoMethod.invoke(invokeTester,"world");
        System.out.println(result2);
    }
}
