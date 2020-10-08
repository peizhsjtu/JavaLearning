package com.java.util.Hashtable;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * 该代码主要用于验证Hashtable的线程安全
 */
public class HashtableConcurrentTest {
    public static final Hashtable<String, String> hashtable = new Hashtable<String, String>();

    public static void main(String[] args) throws InterruptedException {
        //如果要使线程安全，需要使用集合工具类，包装HashMap
        //Collections.synchronizedMap(hashMap)
        Thread t1 = new Thread(){
            public void run(){
                for(int i = 0; i<1000; i++){
                    hashtable.put(String.valueOf(i),String.valueOf(i));
                }
            }
        };

        Thread t2 = new Thread(){
            public void run(){
                for(int j = 1000; j<2000;j++){
                    hashtable.put(String.valueOf(j), String.valueOf(j));
                }
            }
        };

        t1.start();
        t2.start();

        Thread.currentThread().sleep(1000);

        for(int k = 0;k<2000;k++){
            if(!String.valueOf(k).equals(hashtable.get(String.valueOf(k)))){
                System.err.println(String.valueOf(k)+ ":" + hashtable.get(String.valueOf(k)));
            }
        }

    }
}
