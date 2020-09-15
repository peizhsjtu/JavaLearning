package com.company.test1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class ReflectionTest {
    //关于Class：某个类的数据成员名，方法和构造器，某个类到底实现了哪些接口。
    //           对于每个类而言，JRE都为其保留一个不变的Class对象，一个Class对象
    //           包含了特定某个类的有关信息。
    //Class对象只能由系统建立对象。
    //一个类在JVM中只会有一个Class实例。
    //每个类的实例都会记得自己由哪个Class实例所生成。
    public void testClass(){
        Class clazz = null;
        //得到Class对象，1.直接通过类名.class的方式得到
        clazz = Person.class;
        Field[] fields = clazz.getDeclaredFields();
    }
    public static void testNewInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String classname = "my_Generic_Test.person";
        Class clazz = Class.forName(classname);
        //利用Class对象的newInstance方法来创建一个类的对象。
        //实际调用的是类的无参的构造器
        Object object = clazz.newInstance();
        System.out.println(object);
    }
    public static void testMethod() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = Class.forName("my_Generic_Test.person");
        //得到Class对应的类中有哪些方法
        Method[] methods = clazz.getMethods();
        for (Method method:methods){
            System.out.println(method.getName());
        }
        //获取所有的方法，包括私有方法,且只获取当前类声明的方法
        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method method:methods1){
            System.out.println(method.getName());
        }
        //获取指定的方法
        Method method = clazz.getDeclaredMethod("setName", String.class);
        System.out.println(method);

        method = clazz.getDeclaredMethod("setName", String.class, Integer.class);
        System.out.println(method);

        //执行该方法
        Object object = clazz.newInstance();
        method.invoke(object,"zhaoChunya",27);
    }
    //className:某个类的全名；methodName:类的一个方法名，该方法可能是私有方法。
    public static Object invoke1(String className,String methodName,Object...args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object object = null;
        try {
            object = Class.forName(className).newInstance();
            return invoke(object,methodName,args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //obj：方法执行的那个对象
    public static Object invoke(Object obj,String methodName,Object...args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //获取Method对象
        Class[] parameterType = new Class[args.length];
        for(int i = 0;i< args.length;i++){
            parameterType[i] = args[i].getClass();
        }

//        try {
//            //执行Method方法并返回方法的返回值
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Method method = obj.getClass().getDeclaredMethod(methodName,parameterType);
        //return null;
        return method.invoke(obj,args);
    }
    public static void testGetSuperClass() throws ClassNotFoundException {
        String className = "my_Generic_Test.person";
        Class clazz = Class.forName(className);
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }
    //methodName:方法名，该方法有可能是私有方法，也有可能是在父类中定义的私有方法。
    public Object invoke2(Object object,String methodName,Object...args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class[] parameter = new Class[args.length];
        for (int i = 0;i<args.length;i++){
            parameter[i] = args[i].getClass();
        }
        Method method = object.getClass().getDeclaredMethod(methodName,parameter);
        method.setAccessible(true);
        return method.invoke(object,args);
        //return null;
    }
    //获取clazz的methodName方法，该方法有可能是私有方法 ，还可能是父类的私有方法
    private static Method getMethod1(Class clazz1,String methodName,Class...parameterType) {
        for(Class clazz = clazz1;clazz1 != Object.class;clazz1 = clazz1.getSuperclass()){
            //Method method4 = clazz1.getDeclaredMethod("methodName",args);
            try {
                Method method4 = clazz1.getDeclaredMethod(methodName,parameterType);
                method4.setAccessible(true);
                return method4;
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        }
        return null;

    }

    public static void testInvokePrivateMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object object = new Person();
        Class clazz = object.getClass();
        //Method method = clazz.getDeclaredMethod("setName",new Integer(27));
        Method method = clazz.getDeclaredMethod("setName", String.class, Integer.class);
        //若想通过反射访问私有方法，
        method.setAccessible(true);
        method.invoke(object,"赵春芽你",27);
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        //ReflectionTest.testNewInstance();
        //ReflectionTest.testMethod();
//        Object person = new person();
//        ReflectionTest.invoke(person,"setName","赵春芽",27);
//        System.out.println("**--------------------------************");
//        ReflectionTest.invoke1("my_Generic_test.person","setName","zhaochunya",27);
//        ReflectionTest.invoke1("my_Generic_test.person","setName","Chunya",27);
        //ReflectionTest.testGetSuperClass();
        //ReflectionTest.testInvokePrivateMethod();
        //Class clazz = Class.forName("com.company.test1.Student");
        Class clazz = Student.class;
        //Method method = ReflectionTest.getMethod1(clazz,"method1",Integer.class);
        // method.setAccessible(true);
        //System.out.println(method);
        //Method method2 = ReflectionTest.getMethod1(clazz,"method2");

        //method.setAccessible(true);
        //System.out.println(method2);

        Method[] methods = clazz.getDeclaredMethods();
        for( Method m:methods) {
            System.out.println(m);
        }

    }


}
