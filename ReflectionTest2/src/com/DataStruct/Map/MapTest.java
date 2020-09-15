package com.DataStruct.Map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {

        HashMap map = new HashMap();

        map.put("c","zhangsan");
        map.put("b","lisi");
        map.put("a","wagnwu");
        map.put("a","wangmazi");

        System.out.println(map);

        System.out.println("------------------");

        String value = (String) map.get("b");
        System.out.println(value);
        System.out.println("--------------------");
        String value2 = (String) map.get("d");
        System.out.println(value2);
        System.out.println("--------------------");

    }
}
