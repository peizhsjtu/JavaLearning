package com.DataStruct.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMap4 {
    public static void main(String[] args) {
        HashMap map = new HashMap();

        for(int i=0;i<args.length;i++){
            if(map.get(args[i]) == null){
                map.put(args[i],1);
            }else{
                map.put(args[i],(int)map.get(args[i])+1);
            }
        }

        Set set = map.keySet();
        for(Iterator iter = set.iterator();iter.hasNext();){
            String key = (String)iter.next();
            int value = (int)map.get(key);
            System.out.println("key: "+key+", value: "+value);
        }
    }
}
