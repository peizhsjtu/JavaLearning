package com.java.util.WeakHashMap;

import java.util.WeakHashMap;

/**
 * 注意到只有"second"会消失。"first"位于字符串常量池中，"third"保持有强引用，所以手动触发GC不会将它们回收掉。
 */
public class WeakHashMapTest {
    public static void main(String[] args) throws Exception {
        WeakHashMap<String, Integer> map = new WeakHashMap<>();

        map.put("first", 1);
        map.put(new String("second"), 2);
        String third = new String("third");
        map.put(third, 3);

        System.gc();

        System.out.println(map.get("first"));  // 1
        System.out.println(map.get("second")); // null
        System.out.println(map.get("third"));  // 3
    }
}
