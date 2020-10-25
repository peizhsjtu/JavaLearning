package com.java.util.concurrent.semaphore;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 如何实现限流？
 *
 * 答：限流，即在流量突然增大的时候，上层要能够限制住突然的大流量对下游服务的冲击，
 * 在分布式系统中限流一般做在网关层，当然在个别功能中也可以自己简单地来限流，比如
 * 秒杀场景，假如只有10个商品需要秒杀，那么，服务本身可以限制同时只进来100个请求，
 * 其它请求全部作废，这样服务的压力也不会太大。
 */
public class semaphoreTest {
    public static final Semaphore semaphore = new Semaphore(100);
    public static AtomicInteger failCount = new AtomicInteger(0);
    public static AtomicInteger successCount = new AtomicInteger(0);
    public static CountDownLatch cdl = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            Thread run = new Thread(() -> {
                try {
                    secKill();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            run.start();
        }
        cdl.await();
        System.out.println("商品已经秒杀完毕！");

    }

    public static boolean secKill() throws InterruptedException {
        Thread.sleep((long) (Math.random() * 10));
        if (!semaphore.tryAcquire() | cdl.getCount()<=0) {
            System.out.println("no permits, count = " + failCount.incrementAndGet());
            return false;
        }
        cdl.countDown();

        System.out.println("secKill success, count = " + successCount.incrementAndGet());
        semaphore.release();
        return true;
    }
}
