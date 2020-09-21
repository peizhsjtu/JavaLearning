package com.java.lang.staticLearning;

/**
 * 如果静态字段new了一个对象，则先执行对象的构造函数，再执行静态块
 */
public class BooleanTest2 {
    public final boolean value;
    public static final BooleanTest2 TRUE = new BooleanTest2("true");

    static{
        System.out.println("静态块");
    }


    public BooleanTest2(String s){
        System.out.println("构造函数");
        this.value = Boolean.valueOf(s);
    }

    public static void main(String[] args) {
        //System.out.println("kkk"instanceof String);
        System.out.println(BooleanTest2.TRUE);
    }
}
