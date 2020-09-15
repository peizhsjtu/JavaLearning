package com.company.ForEach;

import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String, Integer>();
        for(String s:args){
            map.put(s, null == map.get(s) ? 1 : map.get(s)+1);
        }
    }

}
