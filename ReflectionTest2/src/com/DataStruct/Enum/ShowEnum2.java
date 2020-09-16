package com.DataStruct.Enum;


/**
 * ordinal是返回每个枚举类型的顺序
 */
public class ShowEnum2 {
    public static void main(String[] args) {
        for(OpConstant c:OpConstant.values()){
            System.out.printf("%d, %s, %n",c.ordinal(),c);
        }
    }
}
