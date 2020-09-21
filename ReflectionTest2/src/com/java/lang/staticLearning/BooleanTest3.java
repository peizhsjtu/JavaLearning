package com.java.lang.staticLearning;

/**
 * 【Java】static执行顺序详解（什么情况下父类普通代码块会先运行？）:   https://twocups.cn/index.php/2020/01/22/16/
 * java中代码块和构造方法以及普通方法的代码执行顺序总结 : https://www.cnblogs.com/lyxcode/p/9016322.html
 * 如果静态字段new了一个对象，则先执行对象的构造函数，再执行静态块
 * https://ask.csdn.net/questions/649218
 当你在测试用new C()时，
 首先执行的是静态属性，这时候你的静态属性是new C（），所以在你静态属性这一档 就需要执行一次代码块。但这时候并不执行静态代码块（因为静态代码块只会执行一次啊，你在写测试new C()时已经"预支了"）。
 然后执行的是 静态代码块 第三执行的就是普通代码块。至此你的测试代码中的new C()执行完毕。

 所以当你运行new C() 类的加载顺序是：

 静态属性【静态属性的new-->普通属性-->普通代码块】-->静态代码块-->你测试写的那个new-->普通属性-->普通代码块
 */
public class BooleanTest3 {
    public final boolean value;
    public static final BooleanTest3 TRUE = new BooleanTest3("true");

    static{
        System.out.println("静态块");
    }

    {
        System.out.println("普通块");
    }

    public BooleanTest3(String s){
        System.out.println("构造函数");
        this.value = Boolean.valueOf(s);
    }

    public static void main(String[] args) {
        //System.out.println("kkk"instanceof String);
        System.out.println(BooleanTest3.TRUE);
    }
}
