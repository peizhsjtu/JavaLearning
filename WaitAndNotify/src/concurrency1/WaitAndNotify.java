package concurrency1;

public class WaitAndNotify {
    /*
    编写一个多线程程序，实现这样一个目标：
        1. 存在一个对象，该对象有一个int类型的成员变量counter，该成员变量的初始值为0；
        2. 创建两个线程，其中一个线程对该对象的成员变量counter增1，另一个线程对该对象的成员变量减1；
        3. 输出该对象成员变量counter每次变化后的值；
        4. 最终输出的结果应为：101010101010...
     */

    private int counter;

    public synchronized void increase(){
        while(counter != 0){
            try{
                wait();
            } catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }

        counter ++;
        System.out.println(counter);
        notify();
    }

    public synchronized void decrease(){
        while(counter ==0){
            try{
                wait();
            } catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }

        counter --;

        System.out.println(counter);

        notify();
    }
}
