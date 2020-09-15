package com.methodpassargument.inheritence;
/*
1. 当生成子类对象时，Java默认首先调用父类的不带参数的构造方法。然后执行该构造方法，然后生成父类的对象，接下来再去调用子类的构造方法，生成子类的对象。
2. 要想生成子类的对象，首先需要生成父类的对象，没有父类对象就没有子类对象。比如说，没有父亲，就没有孩子。

3. super关键字：super表示对父类对象的引用。

4. 如果子类使用super()显示调用父类的某个构造方法，那么在执行的时候就会寻找与super()所对应的构造方法而不会再去寻找父类的不带参数的构造方法。

5. 对super的调用作为构造方法的第一条执行语句，前面不能有其他可执行语句。


 */
public class Child extends Parent{
    public Child(){
        //super(1);
        System.out.println("child");
    }
    public static void main(String[] args) {
        Child child = new Child();
    }
}
class Parent{
    public Parent(int a){
        System.out.println("parent");
    }
    public Parent(){
        System.out.println("no args parent");
    }
}
