package com.Thread;

public class LeftRightDeadLockTest {


    public static void main(String[] args) {
        final Object left = new Object();
        final Object right = new Object();
        Thread t1 = new Thread(new Runnable(){
            public void run(){

                synchronized (left){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (right){
                        System.out.println("Thread t1");
                    }
                }
            }
        });


        Thread t2 = new Thread(new Runnable(){
            public void run(){

                synchronized (right){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (left){
                        System.out.println("Thread t2");
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }


}
