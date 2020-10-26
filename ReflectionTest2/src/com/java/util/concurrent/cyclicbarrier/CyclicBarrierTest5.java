package com.java.util.concurrent.cyclicbarrier;

import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 场景说明：
 *
 * 模拟多线程分组计算
 * 有一个大小为50000的随机数组，用5个线程分别计算10000个元素的和
 * 然后在将计算结果进行合并，得出最后的结果。
 * 重点分析：
 *
 * 用5个线程分别计算：定义一个大小为5的线程池。
 * 计算结果进行合并：定义一个屏障线程，将上面5个线程计算的子结果信息合并
 */
public class CyclicBarrierTest5 {
    public static void main(String[] args) {
        long[] arrayLong = new long[50000];
        for (int i = 0; i < 50000; i++) {
            arrayLong[i] = (long) (Math.random() * 100);
        }
        long[] results = new long[5];
        AtomicLong sum = new AtomicLong();

        CyclicBarrier cb = new CyclicBarrier(5, () -> {
            System.out.println("开始多线程计算: ");
            for (int i = 0; i < 5; i++) {
                sum.addAndGet(results[i]);
            }
            System.out.println("结果等于: "+sum.get());
        }
        );

        //ExecutorService es = Executors.newFixedThreadPool(5);
        for (int j = 0; j < 5; j++) {
            int finalJ = j;
            new Thread(() ->{
            long[] arrayTemp = Arrays.copyOfRange(arrayLong, 10000 * finalJ,10000*(finalJ +1));

            for (int i = 0; i < 10000; i++) {
                results[finalJ] += arrayTemp[i];
            }
                System.out.println(Thread.currentThread().getName()+" result: "+results[finalJ]);

            try{
                cb.await();
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }catch(BrokenBarrierException bbe){
                bbe.printStackTrace();
            }
        }).start();
        }

    }
}
