package com.DataStruct.ArrayList;

import java.util.ArrayList;

public class ArrayListTest1 {
    public static void main(String[] args) {

        //ArrayList<Object> arrayList = new ArrayList<Object>();
        ArrayList  arrayList = new ArrayList();
        arrayList.add("hello");
        arrayList.add("world");
        arrayList.add("world");
        arrayList.add("welcome");
        //System.out.println(arrayList);

        Object o1 = arrayList.get(0);
        System.out.println(o1);

        String s1 = (String) arrayList.get(0);
        String s2 = (String) arrayList.get(1);
        String s3 = (String) arrayList.get(2);
        String s4 = (String) arrayList.get(3);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);

        System.out.println("--------------------");

        for(int i = 0;i < arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
        System.out.println("--------------------");

        //arrayList.clear();
        //System.out.println(arrayList.size());
        //System.out.println(arrayList.isEmpty());

        arrayList.remove(0);
        System.out.println(arrayList);

        System.out.println("-------------------");

        arrayList.remove("welcome");
        System.out.println(arrayList);

        System.out.println("--------------------");

        arrayList.add("aaa");
        arrayList.add("bbbb");
        System.out.println(arrayList);

        System.out.println("--------------------");



    }

}
