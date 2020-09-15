package com.DataStruct.StrategyPattern;

public class DivideStrategy implements Strategy{
    public int caculate(int a, int b){
        return a/b;
    }
}
