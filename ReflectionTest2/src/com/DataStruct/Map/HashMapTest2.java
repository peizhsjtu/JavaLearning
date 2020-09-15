package com.DataStruct.Map;

import java.util.HashMap;
import java.util.zip.DeflaterOutputStream;

/**
 * 1. keySet返回的是Set，values返回的是Collections，
 * Set是不能重复的，values是可以重复的，对应于Map的键不能重复，值可以重复的定义。
 *
 * 2. Map(映射): Map的keySet()方法会返回key的集合，因为Map的键是不能重复的，因此keySet()方法的返回类型是Set；而Map的值是可以重复的，因此values()方法的返回类型是Collection，可以容纳重复的元素。
 *
 * 3. HashMap底层维护一个数组(Entry数组)，我们向HashMap中所放置的对象实际上是存储在该数组当中。
 *
 * 4. 当向HashMap中put一对键值时，它会根据key的hashCode值计算出一个位置，该位置就是此对象准备往数组中存放的位置。
 * 5. 如果该位置没有对象存在，就像此对象直接放进数组当中，如果该对象已经有对象存在了，则顺着此存在对象的链开始寻找(Entry 类有一个Entry类型的的next成员变量，指向了该对象的下一个对象)，如果此链上有对象的话，再去使用equals方法进行比较，如果对此链上的某个对象的equals方法比较为false，则将该对象放到数组中，然后将数组中该位置以前存在的那个对象链接到此对象的后面。
 */
public class HashMapTest2 {
    public static void main(String[] args) {
        HashMap map = new HashMap();

        map.put("a", "zhangsan");
        map.put("b","zhangsan");
        System.out.println(map);


    }
}
