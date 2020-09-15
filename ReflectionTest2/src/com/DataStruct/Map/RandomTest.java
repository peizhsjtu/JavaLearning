package com.DataStruct.Map;

import java.util.*;

public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();

        Map map = new TreeMap();

        for(int i = 0;i<50;i++){
            int number = random.nextInt(41) + 10;
            map.put(number,(map.get(number) == null?1:(int)map.get(number)+1));

        }

        Set set = map.entrySet();
        int sum = 0;

        Collection cols = map.values();
        int maxInt = (int)Collections.max(cols);
        System.out.println("出现次数最多为: "+ maxInt);

        for(Iterator iter = set.iterator();iter.hasNext();){
            Map.Entry entry = (Map.Entry)iter.next();
            int key = (int) entry.getKey();
            int value = (int) entry.getValue();
            sum += value;

            System.out.println("key: "+key+", value: "+value);

            if(value==maxInt)
                System.out.println("次数最多对应的key为: "+key);
        }
        System.out.println(sum);





    }
}
