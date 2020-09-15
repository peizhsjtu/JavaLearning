package com.DataStruct.LinkedList;
import com.DataStruct.LinkedList.Node2;
public class Node2Test {
    public static void main(String[] args) {
        Node2 node1 = new Node2("A");
        Node2 node2 = new Node2("B");
        Node2 node3 = new Node2("C");
        Node2 node4 = new Node2("D");

        node1.pre = node4;
        node1.next = node2;

        node2.pre = node1;
        node2.next = node3;

        node3.pre = node2;
        node3.next = node4;

        node4.pre = node3;
        node4.next = node1;

        Node2 head = node1;
        while(head.next != null){
            System.out.println(head.value);
            head = head.next;
        }


    }
}
