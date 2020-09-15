package com.DataStruct.StrategyPattern;

public class SubtractStrategy implements Strategy{
    public int caculate(int a, int b){
        return a-b;
    }
}
