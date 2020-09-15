package com.DataStruct.Enum;

import java.sql.SQLOutput;

/**
 * 枚举类型还提供了两个有用的静态方法values()和valueOf()，我们可以很方便的使用它们.
 */
public class ColorTest {

    public static void main(String[] args) {

        Color myColor = Color.White;
        System.out.println(myColor);


        System.out.println("----------------");
        for(Color clor:Color.values()){
            System.out.println(clor);
        }
    }
}
