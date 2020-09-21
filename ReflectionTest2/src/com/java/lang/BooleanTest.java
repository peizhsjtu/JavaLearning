package com.java.lang;

/**
 * 如果静态字段new了一个对象，则先执行对象的构造函数，再执行静态块
 */
public class BooleanTest {
    public final boolean value;
    public static final BooleanTest TRUE = new BooleanTest("true");
    {
        System.out.println("普通块");
    }

    static{
        System.out.println("静态块");
    }


    public BooleanTest(String s){
        System.out.println("构造函数");
        this.value = Boolean.valueOf(s);
    }

    public static void main(String[] args) {
        //System.out.println("kkk"instanceof String);
        System.out.println(BooleanTest.TRUE);
    }
}
