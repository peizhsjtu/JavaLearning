package com.dynamicproxy.test1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/*
通过这种方式，被代理的对象(RealSubject)可以在运行时动态改变，需要控制的接口(Subject)可以在运行时改变，控制的方式(DynamicSubject类)也可以动态改变，从而实现了非常灵活的动态代理关系。
 */
/*
动态代理步骤
1. 创建一个实现接口InvocationHandler的类，它必须实现invoke方法
2. 创建被代理的类以及接口
3. 通过Proxy的静态方法newProxyInstance(ClassLoader loader, Class[] interfaces, InvocationHandler)创建一个代理
4. 通过代理调用方法
 */
public class Client {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();

        InvocationHandler handler = new DynamicSubject(realSubject);

        Class cl = realSubject.getClass();

        //运行时动态生成class，
        /*
        public class $Proxy0 implements Subject
        其中$Proxy实在运行时动态生成的
         */
        Subject subject = (Subject) Proxy.newProxyInstance(cl.getClassLoader(), realSubject.getClass().getInterfaces(),handler);
        subject.request();
        //System.out.println(subject.getClass());
        Method[] methods = subject.getClass().getMethods();
        for(Method method: methods){
            System.out.println(method);
        }
        System.out.println();
    }
}
