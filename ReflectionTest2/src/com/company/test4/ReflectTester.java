package com.company.test4;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTester {
    public Object copy(Object object) throws Exception{
        Class cl = object.getClass();
        Object objectCopy = cl.getConstructor(new Class[]{}).newInstance(new Object[]{});

        //获得对象的所有成员变量
        Field[] fields = cl.getDeclaredFields();
        for(Field field : fields){
            String name = field.getName();
            String firstLetter = name.substring(0, 1).toUpperCase();
            String getMethodName = "get" + firstLetter + name.substring(1);
            String setMethodName = "set" + firstLetter + name.substring(1);
            Method getMethod = cl.getMethod(getMethodName, new Class[]{});
            Method setMethod = cl.getMethod(setMethodName,new Class[]{field.getType()});

            Object value = getMethod.invoke(object, new Object[]{});
            setMethod.invoke(objectCopy,new Object[]{value});
        }
        return objectCopy;
    }

    public static void main(String[] args) throws Exception {
        Customer customer = new Customer("Tom",22);
        customer.setId(1L);
        ReflectTester test = new ReflectTester();
        Customer customerCopy = (Customer)test.copy(customer);
        System.out.println(customerCopy.getName());
        System.out.println(customerCopy.getAge());
        System.out.println(customerCopy.getId());
        System.out.println(customerCopy.getClass());
    }
}
