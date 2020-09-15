package com.DataStruct.Queue;


public class Queue {
    public Node head;
    public Node tail;
    public Node temp;

    public void put(Object obj){
        temp =new Node(obj);
        if(head ==null){
            head = temp;
            tail = temp;
        }else{
            tail.next = temp;
            tail = tail.next;
        }
    }

    public Object get(){
        if(head == null)
            return null;
        if(head == tail){
            tail = null;
        }
        temp = head;
        head = head.next;
        return temp.value;
    }

    public boolean isEmpty(){
        return head==null;
    }

}

class Node{
    public Object value;
    public Node next;
    public Node(Object obj){
        this.value = obj;
    }
}

