package com.java.util.concurrent.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorTest {
    public static void main(String[] args) {
        System.out.println("RUNNING: "+Integer.toBinaryString(-1<<29));
        System.out.println("SHUTDOWN: "+ Integer.toBinaryString(0<<29));
        System.out.println("STOP: "+ Integer.toBinaryString(1<<29));
        System.out.println("TIDYING: "+ Integer.toBinaryString(2<<29));
        System.out.println("TERMINATED: "+ Integer.toBinaryString(3<<29));

    }
}
