package com.DataStruct.StrategyPattern;

public class MultiplyStrategy implements Strategy{
    public int caculate(int a, int b){
        return a*b;
    }
}
