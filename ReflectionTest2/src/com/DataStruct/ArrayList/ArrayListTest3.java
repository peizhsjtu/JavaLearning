package com.DataStruct.ArrayList;

import java.util.ArrayList;
/*
java1.5之后有自动装箱拆箱 在放入bai容器中时du基本数据类型会被自动装箱成zhi相应的引用类型dao。而且在使用容器时最好使用泛型，即 List<Integer> list=new ArrayList<Integer>();
 */
public class ArrayListTest3 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        list.add(new Integer(3));
        list.add(new Integer(4));
        list.add(new Integer(5));

        System.out.println(list);

        int sum = 0;
        for(int i = 0;i<list.size();i++){
            int value = ((Integer) list.get(i)).intValue();
            sum+= value;
        }

        System.out.println(sum);
    }
}
