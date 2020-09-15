package com.company.ForEach;

import java.util.ArrayList;
import java.util.Collection;

public class ForEachTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        for(int i = 0; i<arr.length;i++){
            System.out.println(arr[i]);
        }

        System.out.println("-----------------");
        //增强for循环
        for(int element: arr){
            System.out.println(element);
        }

        System.out.println("-----------");

        String[] string = {"hello", "world", "welcome"};

        for(String name : string){
            System.out.println(name);
        }

        System.out.println("-----------");

        int[][] arr2 = {{1,2,3},{4,5,6},{7,8,9}};
        for(int[] row:arr2){
            for(int element:row){
                System.out.println(element);
            }
        }

        System.out.println("-------------");

        Collection<String> col = new ArrayList<String>();
        col.add("one");
        col.add("two");
        col.add("three");

        for(String s: col){
            System.out.println(s);
        }

        System.out.println("------------");

        //遍历List的方式
        // 1. 索引for( int i...);
        //2. 迭代器 Iterator;
        //3. 增强for循环.
    }
}
