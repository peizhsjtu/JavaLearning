package com.java.util.concurrent.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableTest2 {
    public static void main(String[] args) {
        List<Num> listNum = new ArrayList<>();
        Random random = new Random();
        for(int i = 0;i<2000000;i++){
            listNum.add(new Num(random.nextInt(200)));

        }

        ExecutorService es = Executors.newFixedThreadPool(5);

        List<Message> resultAll = new ArrayList<>();
        long begin  = System.currentTimeMillis();
        try{
            for(int i = 0;i<5;i++){
                List<Message> result = es.submit(new Task(i * 400000, (i + 1) * 400000, listNum)).get();
                resultAll.addAll(result);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            es.shutdown();
        }

        long end = System.currentTimeMillis();

        System.out.println("所花时间为:"+(end-begin));
        System.out.println(resultAll.size());

    }
}


class Task implements Callable<List<Message>> {
    private int start;
    private int end;
    private List<Num> listNum = new ArrayList<>();


    public Task(int start , int end, List<Num> listNum){
        this.start = start;
        this.end = end;
        this.listNum = listNum;
    }


    public List<Message> call(){
        System.out.println(Thread.currentThread().getName()+" 开始工作...");
        List<Message> listMsg = new ArrayList<>();
        for(int i = start;i < end; i++){
            if(listNum.get(i).getAge()>100){
                Message msg = new Message(listNum.get(i).getAge() + " is to old");
                listMsg.add(msg);
            }
        }
        System.out.println(Thread.currentThread().getName() + "工作完成！");
        return listMsg;
    }
}


class Message{
    private String msg;

    public Message(String msg){
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

class Num{
    private int age;

    public Num(int age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
