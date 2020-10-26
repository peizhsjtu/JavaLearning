package com.java.util.concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * 练习一
 * 练习目的：
 *
 * 了解CyclicBarrier(parties)/getParties()/await()/getNumberWaiting()的基本用法。
 * 理解循环的意义。
 */
public class CyclicBarrierTest {

    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        //通过barrier.getParties()获取开启屏障的方数
        System.out.println("getParties()获取开启屏障的方数: "+ cyclicBarrier.getParties());

        //通过barrier.getNumberWaiting()获取正在等待的线程数
        System.out.println("通过getNumberWaiting()获取正在等待的线程数: 初始--- "+cyclicBarrier.getNumberWaiting());

        new Thread(() -> {
            System.out.println("添加第1个等待线程--- "+Thread.currentThread().getName());
            try{
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+" is running...");
            }catch(Exception e){
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+" is terminated.");
        }).start();
        Thread.sleep(10);
        System.out.println("添加1个线程后正在等待的线程数:"+cyclicBarrier.getNumberWaiting());

        new Thread(() -> {
            System.out.println("添加第2个等待线程--- "+Thread.currentThread().getName());
            try{
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " is running...");
            }catch(Exception e){
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+" is terminated...");
        }).start();
        Thread.sleep(100);
        System.out.println("通过getNumberWaiting()获取正在等待的线程数:打开屏障后---"+cyclicBarrier.getNumberWaiting());

        //已经打开的屏障,再次有线程等待的话,还会重新生效--视为循环
        new Thread(() -> {
            System.out.println("添加第三个线程: " + Thread.currentThread().getName());
            try{
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+" is running...");
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" is terminated.");
        }).start();

        Thread.sleep(10);
        System.out.println("正在等待的线程数为: "+cyclicBarrier.getNumberWaiting());

        new Thread(() -> {
            System.out.println("屏障打开后,再有线程加入等待: "+Thread.currentThread().getName());
            try{
                cyclicBarrier.await();
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +" is terminated.");
        }).start();

        Thread.sleep(10);
        System.out.println("正在等待的线程数: "+cyclicBarrier.getNumberWaiting());

    }
}
