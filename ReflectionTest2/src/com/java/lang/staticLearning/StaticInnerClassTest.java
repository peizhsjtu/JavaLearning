package com.java.lang.staticLearning;

/**
 * 静态内部类加载与外部类无关，不会加载外部类
 *
 * 静态内部类和非静态内部类一样，都不会因为外部内的加载而加载，同时静态内部类的加载不需要依附外部类，在使用时才加载
 *
 * 类加载即只有一条：当虚拟机启动时，用户需要指定一个要执行的主类（包含main（）方法的那个类），虚拟机会先初始化这个主类
 */
public class StaticInnerClassTest {
    public static void main(String[] args) {
        System.out.println(OuterClass.InnerClass.Inner_Date);

    }
}
class OuterClass{
    static {
        System.out.println("外部类静态代码块");
    }

    static class InnerClass{
        public static long Inner_Date = System.currentTimeMillis();
        static{
            System.out.println("内部静态类代码块");
        }
    }
}