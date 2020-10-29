package com.java.util.concurrent.futureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FutureTaskTest {
    public static void main(String[] args) throws Exception {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("正在下载中...");
                TimeUnit.SECONDS.sleep(3);
                return "Hello World!";
            }
        };
        FutureTask<String> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();

        System.out.println("我们做的其他什么吧...");
        System.out.println("从网络下载的结果为:" + futureTask.get());
        System.out.println("Finish!");


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("正在下载中...");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        FutureTask<String> runnableTask = new FutureTask<>(runnable, "我是返回的结果");
        new Thread(runnableTask).start();
        System.out.println("我们做的其他什么吧...");
        System.out.println("从网络下载的结果为:" + runnableTask.get());
        System.out.println("Finish!");
    }
}
