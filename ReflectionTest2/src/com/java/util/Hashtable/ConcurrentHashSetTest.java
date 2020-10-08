package com.java.util.Hashtable;

import java.util.HashSet;
import java.util.Iterator;

public class ConcurrentHashSetTest {
    private static final HashSet hashSet = new HashSet();
    public static void main(String[] args) throws InterruptedException {
        //线程一
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 50; i++) {
                    hashSet.add( String.valueOf(i));
                }
            }
        };

        //线程二
        Thread t2 = new Thread() {
            public void run() {
                Iterator iter = hashSet.iterator();
                while(iter.hasNext()){
                    String value = (String)iter.next();
                    System.out.print(value+"  ");
                }
                System.out.println();
            }
        };
        //线程3
        Thread t3 = new Thread() {
            public void run() {
                for (int i = 50; i < 100; i++) {
                    hashSet.add( String.valueOf(i));
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();

        //主线程休眠1秒钟，以便t1、t2两个线程将firstHashMap填装完毕。
        Thread.currentThread().sleep(1000);


    }
}
