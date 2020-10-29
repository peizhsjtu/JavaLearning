package com.java.util.concurrent.synchronousqueue;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * https://segmentfault.com/a/1190000011207824
 * SynchronousQueue,实际上它不是一个真正的队列,因为他不会为队列中元素维护存储空间.与其他
 * 队列不同的是,它维护一组线程,这些线程在等待着把元素加入或移出队列.
 *
 * 直接交付方式还会将更多关于任务状态的信息反馈给生产者.当交付呗接受时,他就知道消费者已经得到
 * 了任务,而不是简单的把任务放入一个队列——这种区别就好比将文件直接交给同事,还是将文件放到他的
 * 邮箱并希望他能尽快拿到文件.
 *
 * 因为SynchronousQueue没有存储功能,因此put和take会一直阻塞,直到有另一个线程已经准备好
 * 参与到交付过程中.晋档有足够多的消费者,并且总是有一个消费者准备好获取交付的工作时,才适合
 * 使用同步队列.
 */
public class SynchronousQueueTest {
    static class SynchronousQueueProducer implements Runnable{
        BlockingQueue<String> blockingQueue;
        final Random random = new Random();
        public SynchronousQueueProducer(BlockingQueue<String> blockingQueue){
            this.blockingQueue = blockingQueue;
        }

        public void run(){
            while(true){
                try{
                    String data = UUID.randomUUID().toString();
                    System.out.println("Put: "+data);
                    blockingQueue.put(data);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class SynchronousQueueConsumer implements Runnable{
        BlockingQueue<String> blockingQueue;
        public SynchronousQueueConsumer( BlockingQueue<String> blockingQueue){
             this.blockingQueue = blockingQueue;
         }

         public void run(){
            while(true){
                try{
                    String data = blockingQueue.take();
                    System.out.println(Thread.currentThread().getName() + " take: "+data);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
         }
    }


    public static void main(String[] args) {

        final BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        SynchronousQueueProducer synchronousQueueProducer = new SynchronousQueueProducer(blockingQueue);
        SynchronousQueueConsumer synchronousQueueConsumer1 = new SynchronousQueueConsumer(blockingQueue);
        SynchronousQueueConsumer synchronousQueueConsumer2 = new SynchronousQueueConsumer(blockingQueue);
        new Thread(synchronousQueueProducer).start();
        new Thread(synchronousQueueConsumer1).start();
        new Thread(synchronousQueueConsumer2).start();
    }
}
