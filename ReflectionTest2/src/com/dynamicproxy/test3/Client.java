package com.dynamicproxy.test3;

import sun.security.util.AuthResources_it;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        CommonInvocationHandler handler = new CommonInvocationHandler();
        Foo f = null;
        handler.setObj(new FooImpl());
        f = (Foo)Proxy.newProxyInstance(Foo.class.getClassLoader(), new Class[]{Foo.class}, handler);
        f.doAction();
        System.out.println("************************");
        handler.setObj(new FooImpl2());
        f = (Foo)Proxy.newProxyInstance(Foo.class.getClassLoader(),new Class[]{Foo.class}, handler);
        f.doAction();

    }
}
