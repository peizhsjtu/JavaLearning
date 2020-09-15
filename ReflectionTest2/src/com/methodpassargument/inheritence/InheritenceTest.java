package com.methodpassargument.inheritence;
/*
关于继承的3点：
1. 父类有的，子类也有；
2. 父类没有的，子类可以增加；
3. 父类有的，子类可以改变。

关于继承的注意事项“
1. 构造方法不能被继承；
2. 方法和属性可以被继承；
3. 子类的构造方法隐式调用父类的不带参数的构造方法；
4. 当父类没有不带参数的构造方法时，子类需要使用；super来显式调用父类的构造方法，super指的是对父类的引用；
5. super关键字必须是构造方法中的第一行语句。
 */
public class InheritenceTest {
    public static void main(String[] args) {
        Apple apple = new Apple();
        System.out.println(apple.name);
    }

}

class Fruit{
    String name = "fruit";
}

class Apple extends Fruit{
    String name = "apple";
}
