package com.GenericParadigm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenericTest<T> {
    private T foo;

    public T getFoo() {
        return foo;
    }

    public void setFoo(T foo) {
        this.foo = foo;
    }

    public static void main(String[] args) {
        GenericTest<? extends List> qt = null;
        qt = new GenericTest<ArrayList>();
        qt = new GenericTest<LinkedList>();

        //表示qt2可以指向GenericTest这样的对象，里面泛型对象在继承层次中位于list上面,因此ArrayList不可以
        GenericTest<? super List> qt2 = null;
        //qt2 = new GenericTest<LinkedList>();
        qt2 = new GenericTest<Object>();

        GenericTest<String> qt3 = new GenericTest<String>();
        qt3.setFoo("hello world");

        GenericTest<? extends Object> qt4 = null;
        qt4 = qt3;
        System.out.println(qt4.getFoo());

        /*
        使用<?>或是<? extends SomeClass>的申明方式，意味着只能通过该名称来取得所参考实例的信息，或者是移除某些信息，但是不能增加他的信息，因为只知道当中放置的事SomeClass的子类，但不确定是什么类的实例，编译器不让您加入信息，理由是，如果可以加入具体类型信息的话，那么在取回来的时候需要记得取回来的实例是什么类型，然后转换为原来的类型方可进行操作，就失去了使用泛型的意义.
         */
        //下一句执行出错
        //qt4.setFoo("hello world");
    }
}
