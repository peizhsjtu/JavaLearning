package com.java.lang.Integer;


public class IntegerTest {
    public String toString(int i, int radix){
        char[] digits = {'0','1','2','3','4','5',
                         '6','7','8','9','a','b',
                         'c','d','e','f','g','h',
                         'i','j','k','l','m','n',
                         'o','p','q','r','s','t',
                         'u','v','w','x','y','z'};

        boolean negative = (i<0);
        char[] result = new char[33];
        int temp = 32;
        if(!negative)
            i = -i;
        while(i<=-radix){
            result[temp--] = digits[-(i%radix)];
            i = i/radix;
        }
        result[temp] = digits[-i];
        if(negative)
            result[--temp] = '-';

        return new String(result);


    }
    public static void main(String[] args) {
        IntegerTest integerTest = new IntegerTest();
        System.out.println(integerTest.toString(-165,16));
    }
}
