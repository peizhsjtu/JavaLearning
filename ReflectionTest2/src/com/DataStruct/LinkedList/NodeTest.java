package com.DataStruct.LinkedList;

public class NodeTest {
    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node("AA");

        node1.data = "A";
        node2.data = "B";
        node3.data = "C";


        node1.next = node2;
        node2.next = node3;

        int index = 0;
        int target = 1;
        Node pre = node1;
        while(index != target - 1){
            pre = pre.next;
            index++;
        }
        Node temp = pre.next;
        pre.next = node4;
        node4.next = temp;


        Node head = node1;
        while(head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }
}
