package com.java.util.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**https://www.cnblogs.com/kaituorensheng/p/9043494.html
 *
 *                   ==和join的不同处==
 * 场景：流水线上有3个worker: worker1、worker2、worker3,只有当worker1
 * 和worker2两者的阶段一都执行完后才可以执行worker3
 *
 * 此时用join无法实现，只能用CountDownLatch
 */
public class CountDownLatchTest3 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(2);
        Worker3 worker1 = new Worker3("worker1", (long)(Math.random()*10),cdl);
        Worker3 worker2 = new Worker3("worker2",(long)(Math.random()*10),cdl);
        Worker3 worker3 = new Worker3("wroker3", (long)(Math.random()*10),cdl);

        worker1.start();
        worker2.start();

        cdl.await();
        System.out.println("阶段1工作完成！");

        worker3.start();
    }

}

class Worker3 extends Thread{
    private String name;
    private long time;
    CountDownLatch cdl;

    public Worker3(String name, long time, CountDownLatch cdl){
        this.name = name;
        this.time = time;
        this.cdl = cdl;
    }

    @Override
    public void run(){

        try {
            System.out.println(name + " 开始阶段1工作...");
            Thread.sleep(time);
            System.out.println(name + "阶段1工作完成！"+ "耗时:"+time);
            cdl.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            cdl.countDown();
        }

        try{
            System.out.println(name + " 开始阶段2工作...");
            Thread.sleep((long) (Math.random()*10));
            System.out.println(name + "阶段2工作完成！");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
