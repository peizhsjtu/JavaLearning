package com.java.util.concurrent.LinkedBlockingDequeTest;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * BlockingDeque是多线程双头队列接口，LinkedBlockingDeque是其一种实现。
 *
 * Deque的特点是可以同时在队列的两头put、take元素。
 *
 * 在TCP协议中，数据报有一个URG指针。正常情况下，接收者按数据包到达本机的顺序
 * 处理，而对于设置URG标志的数据报则会优先处理。
 *
 * 本文用BlockingDeque模拟TCP的单工通道。正确情况下发送者按顺序将数据追加到
 * Deque的左边，当发生紧急情况时，发送者将数据追加到Deque的右边。接收者总是
 * 从队列的右边读取数据。
 *
 *============================================================
 *
 * 本例中main线程允当Sender的角色，向BlockingDeque添加数据条目，如果数据
 * 条目的编号是３的整数倍，则认为是Urgency数据，被添加到队列的右边，否则添加
 * 到左边。可以看到Urgency数据被Receiver优先处理。
 */
public class LinkedBlockingDequeTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<DataItem> queue = new java.util.concurrent.LinkedBlockingDeque<DataItem>(20);
        try{
            for(int i = 0;i<10;i++){
                DataItem dataItem = new DataItem(i);
                if(dataItem.isUrgency()){
                    queue.putLast(dataItem);
                }else{
                    queue.putFirst(dataItem);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread receiver = new Thread(new Receiver(queue));
        receiver.start();

        while(DataItem.count.get() > 0){
            try{
                Thread.sleep(10);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }

        receiver.interrupt();
        System.out.println("Main finished");


    }


}

class DataItem{
    private final int number;
    private final boolean flag;

    static final AtomicInteger count = new AtomicInteger(0);

    public DataItem(int number){
        this.number = number;
        flag = number%3 ==0 ? true:false;
        count.incrementAndGet();
    }

    public void show(){
        System.out.println("count:" + count.get() + " ,number: " + number + ",type: "+ ((flag ==true)?"Urgency":"Common"));
    }

    public boolean isUrgency(){
        return flag;
    }
}

class Receiver extends Thread{
    private BlockingDeque<DataItem> queue;

    public Receiver(BlockingDeque<DataItem> queue) throws InterruptedException {
        this.queue = queue;
    }

    public void run(){
        DataItem item;

        try{
            while(true){
                item = queue.takeLast();
                item.show();
                DataItem.count.decrementAndGet();
            }
        }catch(InterruptedException ie){
            System.out.println("Receiver finished");
        }
    }
}