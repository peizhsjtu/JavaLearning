package com.java.util.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *熟悉reset()的用法
 * 理解回归初始状态的意义
 */
public class CyclicBarrierTest2 {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cb = new CyclicBarrier(2);
        //如果是一个初始的CyclicBarrier，则reset()之后，什么也不会发生
        System.out.println("初始CyclicBarrier被reset前");
        cb.reset();
        System.out.println("初始CyclicBarrie呗reset后");

        System.out.println("==========================");

        Thread.sleep(100);
        ExecutorService es = Executors.newCachedThreadPool();
//如果是一个已经打开一次的CyclicBarrier，则reset()之后，什么也不会发生
        for(int i = 0; i<2;i++){
            es.submit(() ->{
            try{
                cb.await();
                System.out.println("屏障已经打破");
            }catch(InterruptedException e){
                System.out.println("中断");
                e.printStackTrace();
            }catch (BrokenBarrierException e2){
                System.out.println("发生BrokenBarrierException");
                e2.printStackTrace();
            }});
        }

        cb.reset();
        Thread.sleep(100);
        System.out.println("==========================");

        es.submit(() -> {
            try{
                cb.await();
                System.out.println("屏障又被打破了");
            }catch(InterruptedException ie){
                System.out.println("中断");
            }catch(BrokenBarrierException bbe){
                System.out.println("屏障打破一次后,一个线程在等待时发生BrokenBarrException");
            }
        });
        Thread.sleep(100);
        cb.reset();
        es.shutdown();



    }
}
