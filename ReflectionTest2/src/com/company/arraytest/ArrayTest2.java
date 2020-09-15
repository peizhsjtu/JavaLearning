package com.company.arraytest;

import java.lang.reflect.Array;

public class ArrayTest2 {
    public static void main(String[] args) {
        int[] dims = new int[]{5,10,15};
        //返回原生类型
        System.out.println(Integer.TYPE);
        //返回类对应的对象
        System.out.println(Integer.class);

        //创建长宽高为5,10,15的数组，等价于Object array = Array.newInstance(Integer.TYPE,5,10,15);
        Object array = Array.newInstance(Integer.TYPE,dims);
        System.out.println(array instanceof int[][][]);
        //获得第一维，索引为3的数组，即arrayObj为二维数组
        Object arrayObj = Array.get(array,3);
        Class cl = arrayObj.getClass().getComponentType();

        //获取二维数组arrayObj中索引为5的数组，因此其为一维数组
        arrayObj = Array.get(arrayObj,5);
        //将一维数组的下标为10的元素设置为37
        Array.setInt(arrayObj, 10,37);
        //转换为3维数组
        int[][][] arrayCast = (int[][][]) array;
        System.out.println(arrayCast[3][5][10]);
    }
}
