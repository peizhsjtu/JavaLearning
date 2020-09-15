package com.dynamicproxy.test2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Vector;

public class VectorProxy implements InvocationHandler {
    private Object proxyObj;

    public VectorProxy(Object obj){
        this.proxyObj = obj;
    }

    public static Object factory(Object obj){
        Class cl = obj.getClass();
        return Proxy.newProxyInstance(cl.getClassLoader(), cl.getInterfaces(), new VectorProxy(obj));
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.println("before calling: " + method);
        if(null != args){
            for(Object obj:args){
                System.out.println(obj);
            }
        }
        Object object = method.invoke(proxyObj, args);
        System.out.println("after calling: " + method);
        return object;
    }

    public static void main(String[] args) {
        List V = (List)factory(new Vector());
        V.add("New");
        V.add("York");
        System.out.println(V.getClass());
        V.remove(0);
        System.out.println(V);
    }
}
