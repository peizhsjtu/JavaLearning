package com.java.util.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 场景：模拟10人赛跑。10人跑完后才喊"Game Over."
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        int runnerCount = 10;
        CountDownLatch beginCDL = new CountDownLatch(1);
        CountDownLatch endCDL = new CountDownLatch(10);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i = 0;i<runnerCount;i++){
            int number = i+1;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try{
                        beginCDL.await();
                        Thread.sleep((long) Math.random() * 10000);
                        System.out.println("选手 "+number+" 已经到达终点！");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        endCDL.countDown();
                    }
                }
            };
            executorService.execute(run);
        }

        System.out.println("比赛开始 ...");
        beginCDL.countDown();
        endCDL.await();
        System.out.println("比赛结束");

        executorService.shutdown();
    }
}
