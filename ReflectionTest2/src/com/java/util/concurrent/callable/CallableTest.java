package com.java.util.concurrent.callable;

import java.util.concurrent.*;

/**
 * 线程叠加
 */
public class CallableTest {
    public static void main(String[] args) {
        long begin  = System.currentTimeMillis();

        ExecutorService es = Executors.newCachedThreadPool();

        AddTask addTask1 = new AddTask(0,100000,"任务1");
        AddTask addTask2 = new AddTask(1000001,200000,"任务2");

        Future<Integer> future1 = es.submit( addTask1);
        Future<Integer> future2 = es.submit(addTask2);

        try{
            System.out.println("计算结果为:"+(future1.get()+future2.get()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("耗时为:"+(System.currentTimeMillis()-begin));
    }


}

class AddTask implements Callable<Integer> {
    private int start;
    private int end;
    private String name;

    public AddTask(int start, int end, String name){
        this.start = start;
        this.end = end;
        this.name = Thread.currentThread().getName()+" name";
    }

    public Integer call(){
        System.out.println(name+" 开始执行...");
        int result = 0;
        for(int i = start;i<=end;i++){
            result += i;
        }
        System.out.println(name+" 执行完毕！");

        return result;
    }



}
