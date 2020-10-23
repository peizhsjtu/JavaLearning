package com.java.util.concurrent.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  Consumer 消费者和 Producer 生产者，通过ArrayBlockingQueue 队列获取和添加元素，其中消费者调用了take()方法
 *  获取元素当队列没有元素就阻塞，生产者调用put()方法添加元素，当队列满时就阻塞，通过这种方式便实现生产者消费者模式。
 *  比直接使用等待唤醒机制或者Condition条件队列来得更加简单。
 */
public class ArrayBlockingQueueTest2 {
        private final static ArrayBlockingQueue<Apple> queue= new ArrayBlockingQueue<>(1);
        public static void main(String[] args){

            new Thread(new Producer(queue)).start();
            new Thread(new Producer(queue)).start();
            new Thread(new Consumer(queue)).start();
            new Thread(new Consumer(queue)).start();
        }
    }

    class Apple {
        public static AtomicInteger idGenerator = new AtomicInteger(0);
        private int id;
        public Apple(){
            this.id = idGenerator.getAndIncrement();
        }
        public int getId(){
            return id;
        }

    }

    /**
     * 生产者线程
     */
    class Producer implements Runnable{
        public static Object object = new Object();
        private final ArrayBlockingQueue<Apple> mAbq;
        Producer(ArrayBlockingQueue<Apple> arrayBlockingQueue){
            this.mAbq = arrayBlockingQueue;
        }

        @Override
        public void run() {
            while (true) {
                Produce();
            }
        }

        private void Produce(){
            try {
                    Apple apple = new Apple();
                    mAbq.put(apple);
                    System.out.println("生产:" + apple.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 消费者线程
     */
    class Consumer implements Runnable{
        public static Object object = new Object();

        private ArrayBlockingQueue<Apple> mAbq;
        Consumer(ArrayBlockingQueue<Apple> arrayBlockingQueue){
            this.mAbq = arrayBlockingQueue;
        }

        @Override
        public void run() {
            while (true){
                try {
                    TimeUnit.MILLISECONDS.sleep(3000);
                        comsume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void comsume() throws InterruptedException {
            synchronized (mAbq) {
                Apple apple = mAbq.take();
                System.out.println("消费Apple=" + apple.getId());
            }
        }
}
