package com.DataStruct.StrategyPattern2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DownNameSort implements SortInterface, Comparator<Person> {
    public void sort(List<Person>list){
        Collections.sort(list, this);
    }

    public int compare(Person p1, Person p2){
        int result;
        return ( result = -(p1.getName().compareTo(p2.getName()))) == 0 ? (p1.getId() - p2.getId()) : result;
    }
}
