package com.DataStruct.Enum;

public class ShowEnum {
    public static void enumCompareTo(OpConstant opConstant){
        System.out.println(opConstant);
        for(OpConstant c:OpConstant.values()){
            System.out.println(opConstant.compareTo(c));
        }
    }

    public static void main(String[] args) {
        enumCompareTo(OpConstant.TURN_LEFT);
    }
}
