package com.java.util.concurrent.copyonwritearraylist;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 如上代码当调用iterator()方法获取迭代器时候实际是返回一个COWIterator对象，
 * COWIterator的snapshot变量保存了当前list的内容，cursor是遍历list数据的下标。
 *
 * 这里为什么说snapshot是list的快照呢？明明是指针传递的引用，而不是拷贝。如果在
 * 该线程使用返回的迭代器遍历元素的过程中，其他线程没有对list进行增删改，那么
 * snapshot本身就是list的array,因为它们是引用关系。
 *
 * 但是如果遍历期间，有其他线程对该list进行了增删改，那么snapshot就是快照了，因
 * 为增删改后list里面的数组被新数组替换了，这时候老数组只有被snapshot索引用，所
 * 以这也就说明获取迭代器后，使用改迭代器进行变量元素时候，其它线程对该list进行的
 * 增删改是不可见的，
 *
 * 因为它们操作的是两个不同的数组，这也就是弱一致性的达成。
 * ======================================================
 *如上代码main函数首先初始化了arrayList，然后在启动线程前获取到了arrayList迭代
 * 器，子线程ThreadOne启动后首先修改了arrayList第一个元素的值，然后删除了
 * arrayList中坐标为2，3 的元素。
 *
 * 主线程等待子线程执行完毕后使用获取的迭代器遍历数组元素，从打印的结果来看，子线程里
 * 面进行的操纵是一个都没有生效，这就是迭代器的弱一致性的效果，需要注意的是获取迭代器
 * 必须在子线程操作之前进行。
 *
 *
 *
 * 注意：CopyOnWriteArrayList使用写时拷贝的策略来保证list的一致性，而获取-拷贝-写入
 * 三步并不是原子性的，所以在修改增删改的过程中都是用了独占锁，并保证了同时只有一个线程才
 * 能对list数组进行修改。
 *
 * 另外CopyOnWriteArrayList提供了弱一致性的迭代器，保证在获取迭代器后，其他线程对
 * list的修改该不可见，迭代器遍历时候的数组是获取迭代器时候的一个快照，另外并发包中
 * CopyOnWriteArraySet 底层就是使用它进行实现，感兴趣的可以去翻翻看。
 */
public class CopyOnWriteArrayListTest {
    private static volatile CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();

    public static void main( String[] args ) throws InterruptedException
    {
        arrayList.add("hello");
        arrayList.add("Java");
        arrayList.add("welcome");
        arrayList.add("to");
        arrayList.add("hangzhou");

        Thread threadOne = new Thread(new Runnable() {

            @Override
            public void run() {

                //修改list中下标为1的元素为JavaSe
                arrayList.set(1, "JavaSe");
                //删除元素
                arrayList.remove(2);
                arrayList.remove(3);

            }
        });

        //保证在修改线程启动前获取迭代器
        Iterator<String> itr = arrayList.iterator();

        //启动线程
        threadOne.start();

        //等在子线程执行完毕
        threadOne.join();

        //迭代元素
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    }

}