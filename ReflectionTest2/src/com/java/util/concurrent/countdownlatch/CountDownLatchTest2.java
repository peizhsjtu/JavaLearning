package com.java.util.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest2{
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(2);
        CountDownLatch cdl2 = new CountDownLatch(1);
        Worker worker1 = new Worker("worker1", (long) (Math.random()*10), cdl);
        Worker worker2 = new Worker("worker2", (long) (Math.random()*10), cdl);
        Worker worker3 = new Worker("worker3", (long) (Math.random()*10),cdl2);

        worker1.start();
        worker2.start();

        cdl.await();
        System.out.println("准备工作就绪,开始正式工作...");
        worker3.start();
        System.out.println("全部工作完成！");
    }
}


class Worker extends Thread{
    private long time;
    private String name;
    private CountDownLatch cdl;

    public Worker(String name, long time, CountDownLatch cdl){
        this.name = name;
        this.cdl = cdl;
        this.time = time;
    }

    @Override
    public void run(){
        try{
            System.out.println(name +" 开始工作...");
            Thread.sleep(time * 10000);
            System.out.println(name + " 工作完成！"+"耗时:"+time);
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            cdl.countDown();
        }
    }
}
