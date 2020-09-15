package com.methodpassargument;
/*
如果一个java源文件中定义了多个类，那么这些类中最多只能有一个类是public的。换句话说，定义的多个类可以都不是public的。
 */
public class ParamTest {
    public void changePoint(Point point){
        //运行时取消以下注释进行对比
        //point  = new Point();
        point.x = 3;
        point.y = 4;
    }

    public static void main(String[] args) {
        ParamTest pt = new ParamTest();
        Point point = new Point();
        pt.changePoint(point);

        System.out.println(point.x);
        System.out.println(point.y);
    }

}
class Point{
    int x;
    int y;
}