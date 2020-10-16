package com.java.util.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayTest2 {
    public static void main(String[] args) {

        String[] str = {"a","b","c"};
        List listStr = Arrays.asList(str);
        System.out.println(listStr.size());//3

        int[] i = {1,2,3};
        List listI = Arrays.asList(i);
        System.out.println(listI.size());//1

/**
 * 上面的结果第一个listStr.size()==3，而第二个 listI.size()==1。这是为什么呢？
 *
 * 　　我们看源码，在 Arrays.asList 中，方法声明为  <T> List<T> asList(T... a)。该方法接收一个可变参数，并且这个可变参数类型是作为泛型的参数。我们知道基本数据类型是不能作为泛型的参数的，但是数组是引用类型，所以数组是可以泛型化的，于是 int[] 作为了整个参数类型，而不是 int 作为参数类型。
 *
 * 　　所以将上面的方法泛型化补全应该是：
 */
        System.out.println("============================");



        String[] str2 = {"a","b","c"};
        List<String> listStr2 = Arrays.asList(str2);
        System.out.println(listStr2.size());//3

        int[] i2 = {1,2,3};
        List<int[]> listI2 = Arrays.asList(i2);//注意这里List参数为 int[] ，而不是 int
        System.out.println(listI2.size());//1

        Integer[] in2 = {1,2,3};
        List<Integer> listIn2 = Arrays.asList(in2);//这里参数为int的包装类Integer，所以集合长度为3
        System.out.println(listIn2.size());//3

        System.out.println("================================");

        /**
         * ③、返回的列表ArrayList里面的元素都是引用，不是独立出来的对象
         */

        String[] str3 = {"a","b","c"};
        List<String> listStr3 = Arrays.asList(str3);
//执行更新操作前
        System.out.println(Arrays.toString(str3));//[a, b, c]
        listStr3.set(0, "d");//将第一个元素a改为d
//执行更新操作后
        System.out.println(Arrays.toString(str3));//[d, b, c]


        System.out.println("===================================");

        /**
         *        　④、已知数组数据，如何快速获取一个可进行增删改查的列表List？
         */

        String[] str4 = {"a","b","c"};
        List<String> listStr4 = new ArrayList<>(Arrays.asList(str4));
        listStr4.add("d");
        System.out.println(listStr4.size());//4
    }
}
