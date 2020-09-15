package com.company.varargs;

/**
 *int ...相当于int[]  可变参数本质是一个数组;对于某个声明了可变参数的方法来说，我们既可以传递离散的值，也可以传递数组对象.但如果将方法中的参数定义为数组，那么只能传递数组对象而不能传递离散的值.
 *
 * 如果接收多个参数，则可变参数必须放在参数列表中最后一位;方法最多只能接收一个可变参数.
 */
public class VarargsTest {
    private static int sum(int... nums){

        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int result = sum(1, 2);
        System.out.println(result);

        result = sum(1,2,3,4,5);
        System.out.println(result);

    }
}
