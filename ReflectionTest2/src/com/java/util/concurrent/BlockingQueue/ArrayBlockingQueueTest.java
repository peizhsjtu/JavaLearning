package com.java.util.concurrent.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 这是一个生产者消费者模型的例子，代码中定义了20个生产者线程，1个消费者线程，产品池中最多容纳10个面包
 * 可以看到，生产和消费能够正确并发执行
 */
public class ArrayBlockingQueueTest {
        public static void main(String[] args) {
            int capacity = 10;
            ArrayBlockingQueue<Bread> queue = new ArrayBlockingQueue<Bread>(capacity);

            for (int i = 0; i < 20; i++) {
                new Thread(new Producer(queue)).start();
            }
            new Thread(new Consumer(queue)).start();
        }

        static class Producer implements Runnable {

            //容器
            private final ArrayBlockingQueue<Bread> queue;

            public Producer(ArrayBlockingQueue<Bread> queue) {
                this.queue = queue;
            }

            /* (non-Javadoc)
             * @see java.lang.Runnable#run()
             */
            @Override
            public void run() {
                while (true) {
                    produce();
                }
            }

            public void produce() {
                /**
                 * put()方法是如果容器满了的话就会把当前线程挂起
                 * offer()方法是容器如果满的话就会返回false，也正是我在前一篇中实现的那种策略。
                 */
                try {
                    Bread bread = new Bread();
                    Thread.sleep(2000);
                    queue.put(bread);
                    System.out.println("Producer:" + bread);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        static class Consumer implements Runnable {

            //容器
            private final ArrayBlockingQueue<Bread> queue;

            public Consumer(ArrayBlockingQueue<Bread> queue) {
                this.queue = queue;
            }

            /* (non-Javadoc)
             * @see java.lang.Runnable#run()
             */
            @Override
            public void run() {
                while (true) {
                    consume();
                }
            }

            public void consume() {
                /**
                 * take()方法和put()方法是对应的，从中拿一个数据，如果拿不到线程挂起
                 * poll()方法和offer()方法是对应的，从中拿一个数据，如果没有直接返回null
                 */
                try {
                    Thread.sleep(2000);
                    Bread bread = queue.take();
                    System.out.println("consumer:" + bread);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        static class Bread {
            long time;
            Bread() {
                this.time = System.currentTimeMillis() / 1000;
            }
            @Override
            public String toString() {
                return String.valueOf(time);
            }
        }
    }
