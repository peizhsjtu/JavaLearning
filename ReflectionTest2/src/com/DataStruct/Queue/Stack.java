package com.DataStruct.Queue;

public class Stack {
    public Node head;
    public Node tail;
    public Node temp;

    public void push(Object obj){
        temp = new Node(obj);
        if(head ==null){
            head = temp;
            tail = temp;
        }else{
            tail.next = temp;
            tail = tail.next;
        }
    }

    public Object pop(){
        if(tail == null){
            return null;
        }else if(head == tail){
            temp = head;
            head = tail = null;
            return temp.value;
        }else{
            Node node = head;
            while(node.next != tail){
                node = node.next;
            }
            temp = tail;
            tail = node;
            return temp.value;
        }
    }

    public Object peek(){
        return tail.value;
    }
    public boolean isEmpty(){
        return head == null;
    }
}
