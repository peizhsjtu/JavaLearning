package com.company.test3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectTester {
    //该对象实现对Customer的拷贝操作
    public Object copy(Object object) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class cl = object.getClass();
        System.out.println(cl);
        System.out.println(cl.getName());

        Constructor cons = cl.getConstructor(new Class[]{});
        Object obj = cons.newInstance(new Object[]{});
        //以上两行代码等价于：Object obj = cl.newInstance();
        System.out.println(obj);


        //如果是构造函数需要带参数则应该如下：
        Constructor cons2 = cl.getConstructor(String.class, int.class);
        Object obj2 = cons2.newInstance("world",22);
        return null;
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ReflectTester test = new ReflectTester();
        test.copy(new Customer());
    }
}

class Customer{
    private Long id;
    private String name;
    private int age;

    public Customer(){

    }
    public Customer(String name, int age){
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
