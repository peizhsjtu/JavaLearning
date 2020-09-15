package com.DataStruct.StrategyPattern;

/**
 * 策略模式
 */
public class Client {
    public static void main(String[] args) {
        Environment environment = new Environment(new AddStrategy());

        int a = 10 ;
        int b = 2;

        System.out.println(environment.caculcate(a, b));

        environment.setStrategy(new DivideStrategy());
        System.out.println(environment.caculcate(10, 2));

        environment.setStrategy(new SubtractStrategy());
        System.out.println(environment.caculcate(a, b));

        environment.setStrategy(new MultiplyStrategy());
        System.out.println(environment.caculcate(a, b));
    }
}
