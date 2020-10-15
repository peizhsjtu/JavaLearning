package com.java.util.TreeMap;


import java.util.TreeMap;

/**
 * 在使用自然顺序排序时候，需要区分两种情况：一种是Jdk定义的对象，一种是我们应用自己定义的对象；
 *
 * 在自然顺序比较中，需要让被比较的元素实现Comparable接口，否则在向集合里添加元素时报："java.lang.ClassCastException: com.jiaboyan.collection.map.SortedTest cannot be cast to java.lang.Comparable"异常；
 *
 * 这是因为在调用put()方法时，会将传入的元素转化成Comparable类型对象，所以当你传入的元素没有实现Comparable接口时，就无法转换，遍会报错；
 *
 */

class SortedTest implements Comparable<SortedTest> {
    private int age;
    public SortedTest(int age){
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    //自定义对象，实现compareTo(T o)方法：
    public int compareTo(SortedTest sortedTest) {
        int num = this.age - sortedTest.getAge();
        //为0时候，两者相同：
        if(num==0){
            return 0;
            //大于0时，传入的参数小：
        }else if(num>0){
            return 1;
            //小于0时，传入的参数大：
        }else{
            return -1;
        }
    }
}

public class TreeMapTest2 {
    public static void main(String[] agrs){
        //自然顺序比较
        naturalSort();
    }
    //自然排序顺序：
    public static void naturalSort(){
        //第一种情况：Integer对象
        TreeMap<Integer,String> treeMapFirst = new TreeMap<Integer, String>();
        treeMapFirst.put(1,"jiaboyan");
        treeMapFirst.put(6,"jiaboyan");
        treeMapFirst.put(3,"jiaboyan");
        treeMapFirst.put(10,"jiaboyan");
        treeMapFirst.put(7,"jiaboyan");
        treeMapFirst.put(13,"jiaboyan");
        System.out.println(treeMapFirst.toString());

        //第二种情况:SortedTest对象
        TreeMap<SortedTest,String> treeMapSecond = new TreeMap<SortedTest, String>();
        treeMapSecond.put(new SortedTest(10),"jiaboyan");
        treeMapSecond.put(new SortedTest(1),"jiaboyan");
        treeMapSecond.put(new SortedTest(13),"jiaboyan");
        treeMapSecond.put(new SortedTest(4),"jiaboyan");
        treeMapSecond.put(new SortedTest(0),"jiaboyan");
        treeMapSecond.put(new SortedTest(9),"jiaboyan");
        System.out.println(treeMapSecond.toString());
    }
}