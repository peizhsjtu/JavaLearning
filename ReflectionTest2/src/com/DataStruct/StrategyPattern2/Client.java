package com.DataStruct.StrategyPattern2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Person p1 = new Person(1,"zhangsan", 55);
        Person p2 = new Person(2, "wangmazi",20);
        Person p3 = new Person(5,"zhaoliu", 30);
        Person p4 = new Person(4,"zhangsan",40);

        Person p5 = new Person(10,"wangmazi",80);

        List<Person> list = new ArrayList<Person>();

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);

        Environment e = new Environment(new DownNameSort());

        e.sort(list);

        for(Iterator<Person> iter = list.iterator();iter.hasNext();){
            Person p = iter.next();
            System.out.println(p.getId() + " " + p.getName() + " " + p.getAge());
        }


    }
}
