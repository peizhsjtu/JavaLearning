package com.DataStruct.Map;

import java.util.*;

/**
 * TreeMap按照Key进行排序，默认为升序排列；
 * 可以在构造函数传入Comparator进行将序排列
 https://www.cnblogs.com/shamo89/p/9885779.html*
 */
public class TreeMapTest {
    public static void main(String[] args) {
        //按照key升序排列
        Map<String, Integer> treemap = new TreeMap<String, Integer>();
        
        treemap.put("a",100);
        treemap.put("c",50);
        treemap.put("d",30);
        treemap.put("z",0);
        treemap.put("g",80);

        for(Map.Entry<String,Integer> element:treemap.entrySet()){
            System.out.println(element.getKey() + " : " + element.getValue());
        }

        System.out.println("----------------------------------------");
        //按照key降序排列
        Map<String, Integer> treemap2 = new TreeMap<String, Integer>((String a, String b) -> b.compareTo(a));


        treemap2.put("a",100);
        treemap2.put("c",50);
        treemap2.put("d", 30);
        treemap2.put("z",20);
        treemap2.put("g",30);

        Set<Map.Entry<String, Integer>> set = treemap2.entrySet();
        for(Iterator<Map.Entry<String, Integer>> iter = set.iterator(); iter.hasNext();){

            Map.Entry<String, Integer> entry= iter.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("----------------------------------------");
        //按照value升序排列
        /**
         * TreeMap底层是根据红黑树的数据结构构建的，默认是根据key的自然排序来组织（比如integer的大小，String的字典排序）。所以，TreeMap只能根据key来排序，是不能根据value来排序的（否则key来排序根本就不能形成TreeMap）。
         *
         * 今天有个需求，就是要根据treeMap中的value排序。所以网上看了一下，大致的思路是把TreeMap的EntrySet转换成list，然后使用Collections.sor排序。代码：
         */
        Map<String, Integer> map = new TreeMap<String, Integer>();
        map.put("d", 50);
        map.put("a", 20);
        map.put("z", 10);
        map.put("g", 30);
        map.put("f", 100);

        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, (Map.Entry<String, Integer> e1, Map.Entry<String,Integer> e2) -> e1.getValue() - e2.getValue());

        for(Map.Entry<String,Integer> entry:list){
            System.out.println(entry.getKey() +" : " + entry.getValue());
        }



    }
}
