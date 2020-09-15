package com.DataStruct.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapTest3 {
    public static void main(String[] args) {
        HashMap map = new HashMap();

        map.put("b","bb");
        map.put("a","aa");
        map.put("d","dd");
        map.put("v","vv");
        map.put("c","cc");

        Set set = map.keySet();

        for(Iterator iter = set.iterator();iter.hasNext();){
            Object key = iter.next();
            String value = (String) map.get(key);
            System.out.println("key: "+key+" ,value: "+value);
        }
    }
}
