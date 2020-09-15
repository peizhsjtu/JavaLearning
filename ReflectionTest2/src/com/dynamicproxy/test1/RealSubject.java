package com.dynamicproxy.test1;

public class RealSubject implements Subject{
    public void request(){
        System.out.println("From real subject! ");
    }
}
