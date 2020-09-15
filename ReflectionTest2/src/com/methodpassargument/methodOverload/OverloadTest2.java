package com.methodpassargument.methodOverload;
/*
方法重载(Overload)：表示两个或多个方法名字相同，但方法参数不同。方法参数不同有两层含义：1)参数个数不同。2)参数类型不同。
      注意：方法的返回值对重载没有任何影响。
 */
public class OverloadTest2 {
    public int method(int a, int b){
        System.out.println(a);
        return 1;
    }

    public boolean method(int a){
        System.out.println(a);
        return false;
    }

    public static void main(String[] args) {
        OverloadTest2 test = new OverloadTest2();
        test.method(1);
        test.method(2);
    }
}
