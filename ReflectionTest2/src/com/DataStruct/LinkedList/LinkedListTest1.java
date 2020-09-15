package com.DataStruct.LinkedList;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 一般将数据结构分为两个大类：线性数据结构和非线性数据结构。现行数据结构有线性表，栈，队列，串，数组和文件；非线性数据结构有树和图。
 *
 * 2. 线性表的逻辑结构是n个数据元素的有限序列，数据元素呈线性关系。必存在唯一的称为“第一个”的数据元素；必然存在唯一的称为“最后一个”的数据元素；除了第一个元素外，每个元素有且只有一个前驱元素；除了最后一个元素外，每个元素有且只有最后一个后继元素。所有数据元素在同一个线性表中必须是相同的数据类型。
 *
 * 3. 线性表按其存储结构可分为顺序表和链表。
 *    用顺序存储结构存储的线性表可称为顺序表；
 *    用链式存储结构存储的线性表称为链表。
 * 将线性表中的数据依次存放在某个存储区域中，所形成的表称为顺序表。一维数组就是用顺序方式存储的线性表。
 *
 * 4. ArrayList底层采用数组实现，LinkedList底层采用双向链表实现。
 *
 * 当执行插入或者删除时，采用LinkedList比较好
 * 当执行搜索操作时，采用ArrayList比较好
 */
public class LinkedListTest1 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        list.addLast("Z");
        list.addFirst("A1");

        list.add(1,"A2");

        System.out.println("最初的集合: "+list);

        System.out.println("---------------");

        list.remove("B");
        list.remove(2);
        System.out.println("删除元素之后的集合: " + list);

        System.out.println("---------------");

        Object value = list.get(2);
        list.set(2, (String) value+"changed");
        System.out.println("更改元素之后的集合: "+ list);
    }
}
