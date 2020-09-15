package com.dynamicproxy.test3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CommonInvocationHandler implements InvocationHandler {
    private Object obj;
    public CommonInvocationHandler(Object obj){
        this.obj = obj;
    }

    public CommonInvocationHandler(){

    }

    public void setObj(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        return method.invoke(obj, args);
    }
}
