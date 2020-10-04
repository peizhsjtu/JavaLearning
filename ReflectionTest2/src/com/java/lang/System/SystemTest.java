package com.java.lang.System;

import java.util.AbstractList;

public class SystemTest {
    public static void main(String[] args) {
        System.out.println(SystemOutter.temp.val);

        SystemOutter.temp.printval();
    }
}

final class SystemOutter{
    public final static SystemOutter2 temp = new SystemOutter2();

}

final class SystemOutter2{
    int val = 10;

    public void printval(){
        System.out.println("hahhahah");
    }
}