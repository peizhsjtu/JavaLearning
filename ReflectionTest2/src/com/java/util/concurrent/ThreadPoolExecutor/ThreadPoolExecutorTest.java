package com.java.util.concurrent.ThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 任务1：被核心线程1执行
 * 任务2：被核心线程2执行
 * 任务3：此时已经没有核心线程了，所以被放到有界面队列里面，任务个数：1
 * 任务4：此时已经没有核心线程了，所以被放到有界面队列里面，任务个数：2
 * 任务5：此时已经没有核心线程了，所以被放到有界面队列里面，任务个数：3 (任务队列满)
 * 任务6：核心线程都被占用了，队列也已经满了，所有创建新线程3来执行
 * 任务7：核心线程都被占用了，队列也已经满了，所有创建新线程4来执行(达到最大线程数)
 * 任务8：队列满了，也达到最大线程数了，被拒绝掉(执行任务拒绝策略)
 * 任务9：队列满了，也达到最大线程数了，被拒绝掉(执行任务拒绝策略)
 * 任务10：队列满了，也达到最大线程数了，被拒绝掉(执行任务拒绝策略)
 * 核心线程1把任务1执行完毕，从任务队列中拿出任务3执行
 * 核心线程2把任务2执行完毕，从任务队列中拿出任务4执行
 * 线程3把任务6执行完毕，从任务队列中拿出任务5执行，
 * ...
 * 然后回收空闲线程
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));
        for (int i = 1; i <= 10; ++i) {
            final int index = i;
            Runnable runnable = () -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "我是任务" + index);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            executor.submit(runnable);
            //这里确认id小的任务先提交到线程池
            TimeUnit.MILLISECONDS.sleep(30);
        }
        executor.shutdown();
    }
}
