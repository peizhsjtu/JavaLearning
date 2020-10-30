package com.java.util.concurrent.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    public static void main(String[] args) {
Condition
        BoundedQueue<Integer> queue = new BoundedQueue<>(3);
        Thread increseThread = new IncreseThread(queue);
        Thread decreseThread = new DecreseThread(queue);

        increseThread.start();
        decreseThread.start();
    }
}

class BoundedQueue<T>{
    private List<T> queue;
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();
    private int maxSize;

    public BoundedQueue(int maxSize){
        queue = new ArrayList<>();
        this.maxSize = maxSize;
    }


    public void add(T element){
        lock.lock();
        try{
            while(queue.size() == this.maxSize){
                notFull.await();
            }
            queue.add(element);
            System.out.println("添加元素: "+element);
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public void remove(){
        lock.lock();
        try{
            while(queue.size() == 0){
                notEmpty.await();
            }
            T element = queue.remove(0);
            System.out.println("移除元素: "+element);
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}

class IncreseThread extends Thread{
    BoundedQueue<Integer> queue;
    public IncreseThread(BoundedQueue<Integer> queue){
        this.queue = queue;
    }

    public void run(){
        for(int i = 0; i < 30; i++){
            try{
                Thread.sleep((long) (Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            queue.add(i);
        }
    }
}


class DecreseThread extends Thread{
    private BoundedQueue<Integer> queue;

    public DecreseThread(BoundedQueue<Integer> queue){
        this.queue = queue;
    }

    public void run(){
        for(int i = 0;i< 30;i++){
            try{
                Thread.sleep((long) (Math.random()*10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            queue.remove();
        }
    }
}