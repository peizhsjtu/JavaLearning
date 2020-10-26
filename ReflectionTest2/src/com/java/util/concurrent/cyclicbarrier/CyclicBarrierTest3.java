package com.java.util.concurrent.cyclicbarrier;

import java.util.concurrent.*;

/**
 *练习三
 * 练习目的：
 *
 * 练习await()/await(timeout,TimeUnit)/isBroken()的使用方法
 * 理解破损标志位broken的状态转换
 */
public class CyclicBarrierTest3 {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        ExecutorService es = Executors.newCachedThreadPool();

        //添加一个用await()等待的线程
        es.submit(() -> {
            try{
                cyclicBarrier.await();
                System.out.println("屏障打开");
            }catch(InterruptedException ie){
                System.out.println(Thread.currentThread().getName()+" is interrupted.");
            }catch(BrokenBarrierException bbe){
                System.out.println(Thread.currentThread().getName() + " is been broken.");
            }
        });

        Thread.sleep(100);
        System.out.println("刚开始,屏障是否破损: "+ cyclicBarrier.isBroken());

        //添加一个等待线程-并超时
        es.submit(() -> {
            try{
                cyclicBarrier.await(1, TimeUnit.SECONDS);
                System.out.println("屏障打开");
            }catch(InterruptedException ie){
                System.out.println(Thread.currentThread().getName() + " is interrupted.");
            }catch(BrokenBarrierException bbe){
                System.out.println(Thread.currentThread().getName() + " is been broken.");
            }catch (TimeoutException te){
                System.out.println(Thread.currentThread().getName() + " is timeout.");
            }
        });

        Thread.sleep(100);
        System.out.println("当前等待线程数量: "+ cyclicBarrier.getNumberWaiting());
        Thread.sleep(1000);
        System.out.println("当前等待线程数量: "+ cyclicBarrier.getNumberWaiting());
        System.out.println("当前等待的线程timeout时,当前屏障是否破损: "+ cyclicBarrier.isBroken());
        System.out.println("等待的线程中,如果有一个出现问题,则此线程会抛出相应的异常;其他线程都会抛出BrokenBarrierException异常.");

        Thread.sleep(5000);
        cyclicBarrier.reset();
        System.out.println("reset之后,当前屏障是否破损: "+ cyclicBarrier.isBroken());
        System.out.println("reset之后,当前等待线程数量: "+ cyclicBarrier.getNumberWaiting());

        es.shutdown();

    }
}
