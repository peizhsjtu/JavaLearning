package com.DataStruct.Enum;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

public class EnumMapDemo {
    public static void main(String[] args) {
        Map<Action, String> map = new EnumMap<Action,String>(Action.class);

        map.put(Action.TURN_LEFT,"xiangzuozhuan");
        map.put(Action.TURN_RIGHT,"xiangyouzhuan");
        map.put(Action.SHOOT,"sheji");

        for(Iterator<Map.Entry<Action,String>> iter = map.entrySet().iterator(); iter.hasNext();){
            Map.Entry<Action, String> entry =  iter.next();
            Action action = entry.getKey();
            String s = entry.getValue();
            System.out.println(action+ " : " + s);
        }

        System.out.println("----------------------");

        for(Action action:Action.values()){
            System.out.println(map.get(action));
        }
    }
}

enum Action{
    TURN_LEFT, TURN_RIGHT, SHOOT
}
