package com.DataStruct.Set;

import java.util.HashSet;
/**
 * 1. 当使用HashSet时，hashCode()方法就会得到调用，判断已经存储在集合中的对象的hash code值是否与增加的对象的hash code值一致;如果不一致，直接加进去；如果一致，再进行equals方法的比较，equals方法如果返回true，表示对象已经加进去了，就不会再增加新的对象，否则加进去。
 *
 * 2. 如果我们重写equals方法，那么也要重写hashCode方法，反之亦然。
 */
public class SetTest2 {
    public static void main(String[] args) {

        HashSet set = new HashSet();

        set.add(new People("zhangsan"));
        set.add(new People("lisi"));
        set.add(new People("zhangsan"));
        System.out.println(set);


        System.out.println("--------------------");


        HashSet set2 = new HashSet();
        People p = new People("zhangsan");
        set2.add(p);
        set2.add(p);
        System.out.println(set2);

        System.out.println("-------------");

        HashSet set3 = new HashSet();
        String s1 = new String("a");
        String s2 = new String("a");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        set3.add(s1);
        set3.add(s2);
        System.out.println(set3);
    }
}
class People{
    String name;

    public People(String name){
        this.name = name;
    }
}
