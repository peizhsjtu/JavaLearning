package com.java.util.concurrent.countdownlatch;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Worker2 worker1 = new Worker2("worker1", (long)(Math.random()*10));
        Worker2 worker2 = new Worker2("worker2", (long) (Math.random()*10));
        Worker2 worker3 = new Worker2("worker3", (long)(Math.random()*10));

        worker1.start();
        worker2.start();

        worker1.join();
        worker2.join();

        System.out.println("准备工作就绪,开始正式工作...");

        worker3.start();
    }
}

class Worker2 extends Thread{
    private String name;
    private long time;
    public  Worker2(String name, long time){
        this.name = name;
        this.time = time;
    }

    @Override
    public void run(){
        try{
            System.out.println(name + " 开始工作...");
            Thread.sleep(time);
            System.out.println(name + " 工作完成！+耗时: "+time);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
