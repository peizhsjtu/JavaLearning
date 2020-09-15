package com.DataStruct.StrategyPattern2;

import java.util.List;

public class Environment {

    private SortInterface sortInterface;

    public Environment(SortInterface sortInterface){
        this.sortInterface = sortInterface;
    }

    public Environment(){}

    public void sort(List<Person>list){
        this.sortInterface.sort(list);
    }
}
