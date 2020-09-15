package com.DataStruct.Enum;

/**
 * 1. 定义枚举类型时本质上就是定义一个类别，只不过很多细节由编译器帮完成了，所以某些程度上，enum关键字的作用像是class或interface.
 *
 * 2. 当使用"enum"定义枚举类型时，实质上定义出来的类型继承自java.lang.Enum类型，而每个枚举的成员实际上就是定义的枚举类型的一个实例(Instance)，他们都被预设为final,因此无法被改变，它们也是static成员，所以可以通过类型名字直接使用它们，都是public的.
 *
 * 3. 每个枚举的成员就是定义的枚举类型的一个实例(Instance).换句话说，当定义了一个枚举类型以后，在编译时刻就能确定枚举类型有几个实例，分别是什么。在运行期间我们无法使用该枚举类型穿件新的实例了，这些实例在编译期间就已经完全确定下来了.
 *
 *
 */
public enum Coin {
    penny("hello"),nickle("world"),dime("welcome"),quarter("hello world");
    private String value;

    public String getValue(){
        return value;
    }

    Coin(String value){
        this.value = value;
    }

    public static void main(String[] args) {
        Coin coin = Coin.quarter;
        System.out.println(coin.getValue());
    }
}
