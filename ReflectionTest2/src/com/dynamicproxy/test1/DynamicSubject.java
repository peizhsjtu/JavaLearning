package com.dynamicproxy.test1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 该代理类的内部属性是Object类型，实际使用的时候通过该类的构造方法传递进来一个对象。此外，该类还实现了invoke方法，该方法中的method.invoke其实是通过调用被代理对象的将要执行的方法，方法参数是sub，表示该方法从属于sub，通过动态代理类，我们可以在执行真是对象前后加入自己的一些额外方法。
 */
public class DynamicSubject implements InvocationHandler {
    private Object sub;
    public DynamicSubject(Object object){
        this.sub = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.println("before calling: "+ method);
        method.invoke(sub, args);
        System.out.println("after caling: " + method);

        return null;
    }
}
