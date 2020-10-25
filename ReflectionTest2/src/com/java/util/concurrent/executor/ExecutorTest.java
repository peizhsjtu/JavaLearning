package com.java.util.concurrent.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *     // runState is stored in the high-order bits
 *     //高3位：111：接受新任务并且继续处理阻塞队列中的任务
 *     private static final int RUNNING    = -1 << COUNT_BITS;
 *     //高3位：000：不接受新任务但是会继续处理阻塞队列中的任务
 *     private static final int SHUTDOWN   =  0 << COUNT_BITS;
 *     //高3位：001：不接受新任务，不在执行阻塞队列中的任务，中断正在执行的任务
 *     private static final int STOP       =  1 << COUNT_BITS;
 *     //高3位：010：所有任务都已经完成，线程数都被回收，线程会转到TIDYING状态会继续执行钩子方法
 *     private static final int TIDYING    =  2 << COUNT_BITS;
 *     //高3位：110：钩子方法执行完毕
 *     private static final int TERMINATED =  3 << COUNT_BITS;
 */
public class ExecutorTest {
    public static void main(String[] args) {
        System.out.println("RUNNING: "+Integer.toBinaryString(-1<<29));
        System.out.println("SHUTDOWN: "+ Integer.toBinaryString(0<<29));
        System.out.println("STOP: "+ Integer.toBinaryString(1<<29));
        System.out.println("TIDYING: "+ Integer.toBinaryString(2<<29));
        System.out.println("TERMINATED: "+ Integer.toBinaryString(3<<29));

    }
}
