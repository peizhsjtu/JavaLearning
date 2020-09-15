package com.DataStruct.ArrayList;

import java.awt.*;
import java.util.ArrayList;
/*
集合中存放的依然是对象的引用而不是对象本身。
 */

/**
 *1. ArrayList底层采用数组实现，当使用不带参数的构造方法生成ArrayList对象时，实际上会在底层生成一个长度为10的Object类型数组。
 *
 *2. (add方法) 如果增加的元素个数超过了10个，那么ArrayList底层会新生成一个数组，长度为原数组的1.5倍，然后将原数组的内容复制到新数组当中，并且后续增加的内容都会放到新数组中。当新数组无法容纳增加的元素时，重复该过程。
 *
 * 3. (remove)对于ArrayList元素的删除操作，需要将被删除元素的后续元素向前移动，代价比较高。
 *
 */
public class ArrayList5 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        list.add(new Point(2,3));
        list.add(new Point(3,4));
        list.add(new Point(4,5));

        for(int i = 0;i<list.size();i++){
            //会调用Point的toString方法，但是Point没有重写Object的toString方法，因此会调用Object的toString方法。
            System.out.println(list.get(i));
        }

        System.out.println(list);
    }
}

/**
 *
 */
class Point{
    int x,y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "x=" + this.x + ", y= "+ this.y;
    }
}
