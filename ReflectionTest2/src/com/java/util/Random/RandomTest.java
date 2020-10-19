package com.java.util.Random;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.UUID;

public class RandomTest {
    public static void main(String[] args) {
            Random random = new Random(47);
            for(int i = 0; i < 3; i++){
                System.out.print(random.nextInt(20) + " ");
            }
            System.out.println();
            Random randomII = new Random(47);
            for(int i = 0; i < 10; i++){
                System.out.print(randomII.nextInt(20)+ " ");
            }
    }
}
