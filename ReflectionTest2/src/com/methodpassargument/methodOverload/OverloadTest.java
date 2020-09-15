package com.methodpassargument.methodOverload;

/*
方法重载(Overload)：表示两个或多个方法名字相同，但方法参数不同。方法参数不同有两层含义：1)参数个数不同。2)参数类型不同。
      注意：方法的返回值对重载没有任何影响。
 */

public class OverloadTest {
    public int add(int a, int b){
        return a+b;
    }

    public int add(int a, int b, int c){
        return a+b+c;
    }

    public static void main(String[] args) {
        OverloadTest test = new OverloadTest();

        int result1 = test.add(1, 2);
        int result2 = test.add(1,2,3);

        System.out.println(result1);
        System.out.println(result2);
    }
}
