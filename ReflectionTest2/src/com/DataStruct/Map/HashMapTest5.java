package com.DataStruct.Map;

import java.util.*;

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
