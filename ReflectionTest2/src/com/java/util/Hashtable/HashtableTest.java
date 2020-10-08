package com.java.util.Hashtable;

import java.util.*;

public class HashtableTest {
    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable();

        hashtable.put("1", "aa");
        hashtable.put("2", "bb");
        hashtable.put("3", "cc");
        hashtable.put("4", "dd");

        //[1]Hashtable包含contains方法，但是HashMap不包含contains
        if(hashtable.contains("aa"))
            System.out.println("contains method available");
        if(hashtable.containsKey("1"))
            System.out.println("containsKey method available");

        System.out.println("=========================");
        //[2]toString 打印
        System.out.println(hashtable.toString());
        System.out.println("=========================");

        //[3]Iterator遍历方式
        Set<Map.Entry<String, String>> set = hashtable.entrySet();
        for(Iterator<Map.Entry<String, String>> iter = set.iterator(); iter.hasNext();){
            Map.Entry<String, String> entry = iter.next();
            System.out.println("key: " + entry.getKey()+", value: "+ entry.getValue());
        }

        System.out.println("========================");
        //[4]for循环遍历
        for(Map.Entry<String, String> entry : set){
            System.out.println("key: "+ entry.getKey()+", value: "+entry.getValue());
        }

        System.out.println("=======================");
        //[5]Iterator遍历方式2-key键遍历
        Set<String> valueSet = hashtable.keySet();
        for(Iterator<String> iter = valueSet.iterator();iter.hasNext();){
            String key = iter.next();
            System.out.println("key: "+ key+", value: "+ hashtable.get(key));
        }

        System.out.println("=======================");

        //[6]通过Enumeration来遍历Hashtable
        Enumeration<String> enu = hashtable.keys();
        for(; enu.hasMoreElements();){
            System.out.println("Enumeration: "+" "+ enu.nextElement());
        }

    }
}
