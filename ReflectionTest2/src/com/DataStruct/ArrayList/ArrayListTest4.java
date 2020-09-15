package com.DataStruct.ArrayList;

import java.util.ArrayList;
/*
不能将Object[]数组转换成Integer[]类型数组
Integer[]虽然继承了Object对象，但是没继承Object[]数组
Object[]{"ss",new Integer(3)}

 */
public class ArrayListTest4 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(3));
        list.add(new Integer(4));
        list.add(new Integer(5));
        list.add(new Integer(6));

        //Integer[] in = (Integer[]) list.toArray();
        Object[] in = list.toArray();
        for(int i = 0; i<in.length;i++){
            System.out.println(((Integer)in[i]).intValue());
        }


    }
}
