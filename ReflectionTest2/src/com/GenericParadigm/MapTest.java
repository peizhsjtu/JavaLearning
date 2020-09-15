package com.GenericParadigm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String,String>();

        map.put("a","aa");
        map.put("b","bb");
        map.put("c","cc");
        map.put("d","dd");

        Set<String> set = map.keySet();
        for(Iterator<String> iter = set.iterator();iter.hasNext();){
            String key = iter.next();
            String value = map.get(key);

            System.out.println(key+" : "+value);
        }

        System.out.println("------------------");

        Set<Map.Entry<String,String>> entrySet = map.entrySet();
        for(Iterator<Map.Entry<String,String>> iter = entrySet.iterator();iter.hasNext();){
            Map.Entry<String,String> entry = iter.next();
            System.out.println(entry.getKey()+ " : " + entry.getValue());
        }

    }
}
