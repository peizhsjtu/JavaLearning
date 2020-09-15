package com.GenericParadigm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 无论是接口还是类都用extends;当没有指定泛型继承的类型或接口时，默认使用T extends Object,所以默认情况下任何类型都可以作为参数传入.
 *
 * @param <T>
 */
public class ListGenericFoo<T extends List> {
    private T[] fooArray;

    public T[] getFooArray() {
        return fooArray;
    }

    public void setFooArray(T[] fooArray) {
        this.fooArray = fooArray;
    }

    public static void main(String[] args) {
        ListGenericFoo<LinkedList> foo1 = new ListGenericFoo<LinkedList>();

        ListGenericFoo<ArrayList> foo2 = new ListGenericFoo<ArrayList>();

        LinkedList[] linkedList = new LinkedList[10];
        foo1.setFooArray(linkedList);

        ArrayList[] arrayList = new ArrayList[10];
        foo2.setFooArray(arrayList);

        // ListGenericFoo<HashMap> foo3 = new ListGenericFoo<HashMap>();
    }
}
