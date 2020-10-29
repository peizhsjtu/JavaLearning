package com.java.util.concurrent.atomic;

import java.util.stream.IntStream;

public class AtomicIntegerTest {
    public static int count = 0;

    public static void increment(){
        count++;
    }

    public static void main(String[] args) {
        IntStream.range(0,100).forEach(
                i ->
                        new Thread(() ->
                                IntStream.range(0, 1000)
                        .forEach(j -> increment())).start()
        );

        while(Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(count);
    }
}
