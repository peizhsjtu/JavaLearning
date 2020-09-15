package com.DataStruct.Set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest2 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet(new Person());
        Person p1 = new Person(10);
        Person p2 = new Person(5);
        Person p3 = new Person(30);
        Person p4 = new Person(20);

        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);

        System.out.println(set);

        for (Iterator iter = set.iterator();iter.hasNext();){
            Person p = (Person) iter.next();
            System.out.println(p.score);
        }
    }
}

class Person implements Comparator {
    int score;

    public Person(int score){
        this.score = score;
    }
    public Person(){}

    public String toString(){
        return String.valueOf(this.score);
    }

    public int compare(Object o1, Object o2){
        return ((Person)o1).score - ((Person)o2).score;
    }
}
