package com.synchronizedWaitNotify;

import java.util.concurrent.TimeUnit;

/**
 * 使用时切记：必须由同一个lock对象调用wait、notify方法
 *
 * 当线程A执行wait方法时，该线程会被挂起；
 *
 * 当线程B执行notify方法时，会唤醒一个被挂起的线程A；
 *
 * lock对象、线程A和线程B三者是一种什么关系？
 *
 * 根据上面的案例，可以想象一个场景：
 *
 * lock对象维护了一个等待队列list；
 *
 * 线程A中执行lock的wait方法，把线程A保存到list中；
 *
 * 线程B中执行lock的notify方法，从等待队列中取出线程A继续执行；
 *
 * 作者：咸鱼君0808
 * 链接：https://www.jianshu.com/p/ffc0c755fd8d
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class WaitNotifyTest {
        public static void main(String[] args) {
            final Object lock = new Object();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程 A 等待 获得 锁");
                    synchronized (lock) {
                        try {
                            System.out.println("线程 A 获得 锁");
                            TimeUnit.SECONDS.sleep(1);
                            System.out.println("线程 A 开始 执行 wait() ");
                            lock.wait();
                            System.out.println("线程 A 结束 执行 wait()");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程 B 等待 获得 锁");
                    synchronized (lock) {
                        System.out.println("线程 B 获得 锁");
                        try {
                            TimeUnit.SECONDS.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        lock.notify();
                        System.out.println("线程 B 执行 notify()");
                    }
                }
            }).start();
        }
    }
