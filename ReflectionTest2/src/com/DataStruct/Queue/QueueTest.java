package com.DataStruct.Queue;

public class QueueTest {
    public static void main(String[] args) {

        Queue queue = new Queue();
        queue.put("A");
        queue.put("B");
        queue.put("C");
        queue.put("D");

        System.out.println(queue.isEmpty());
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
    }
}
