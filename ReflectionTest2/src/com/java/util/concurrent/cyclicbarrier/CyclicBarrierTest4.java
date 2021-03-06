package com.java.util.concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * 练习四
 * 练习目的：
 *
 * 练习CyclicBarrier(int parties, Runnable barrierAction)的用法
 * 理解屏障线程的意义
 */
public class CyclicBarrierTest4 {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () ->{
            System.out.println("屏障放开,[屏障线程]先运行！");
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[屏障线程]的事情做完了！");
        });

        for(int i = 0;i < 2; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "等待屏障放开！");
                try{
                    cyclicBarrier.await();
                }catch(Exception e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "开始干活...干活结束！");
            }).start();
        }
    }
}
