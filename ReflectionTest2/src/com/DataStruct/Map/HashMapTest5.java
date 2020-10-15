package com.DataStruct.Map;

import java.util.*;

/**
 * 使用自定义比较器排序
 *
 * 使用自定义比较器排序，需要在创建TreeMap对象时，将自定义比较器对象传入到TreeMap构造方法中；
 *
 * 自定义比较器对象，需要实现Comparator接口，并实现比较方法compare(T o1,T o2)；
 *
 * 值得一提的是，使用自定义比较器排序的话，被比较的对象无需再实现Comparable接口了；
 *
 */
public class HashMapTest5 {
    public static void main(String[] args) {
        HashMap map = new HashMap();

        map.put("a","aa");
        map.put("f","ff");
        map.put("d","dd");
        map.put("z","zz");
        map.put("c","cc");
        map.put("a","ff");

        Set set = map.entrySet();

        for(Iterator iter = set.iterator();iter.hasNext();){
            Map.Entry entry = (Map.Entry)iter.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key: "+key+" ,value: "+value);
        }

        TreeMap treeMap;
    }
}
