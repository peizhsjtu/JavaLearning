package com.methodpassargument.ConstructorOverload;

/*
构造方法重载：只需要看参数即可。如果想在一个构造方法中调用另外一个构造方法，那么可以使用this()的方式调用，this()括号中的参数表示目标构造方法需要接收的参数。
 */
public class ConstructorOverload {
    public ConstructorOverload(){
        //this表示对当前对象的引用
        this(3);
        System.out.println("ConstructorOverload: No param");
        //对this()构造方法的调用必须放在构造方法的第一条语句，换句话说，this()之前不能有任何可执行的代码。
        //this(3)
    }

    public ConstructorOverload(int i){
        System.out.println(++i);
    }

    public static void main(String[] args) {
        ConstructorOverload col = new ConstructorOverload();
    }
}
