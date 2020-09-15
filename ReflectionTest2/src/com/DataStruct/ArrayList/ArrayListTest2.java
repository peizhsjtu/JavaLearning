package com.DataStruct.ArrayList;

import java.util.ArrayList;
/*
ArrayList接收类型为Object


 */
public class ArrayListTest2 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();

        arrayList.add("hello");
        arrayList.add(new Integer(2));

        String str = (String) arrayList.get(0);
        Integer in = (Integer) arrayList.get(1);

        System.out.println(str);
        System.out.println(in.intValue());
        System.out.println("-------------------");
        //下面两个语句运行会报错但是编译期间不会报错，因为get获取对象类型为Object类型，Object类型转换成String类型是合法的，但是Integer类型与String类型不能强制转换，因此运行期间报错。
        //String in2 = (String) arrayList.get(1);
        //System.out.println(in2);



    }
}
