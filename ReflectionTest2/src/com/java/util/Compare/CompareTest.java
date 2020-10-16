package com.java.util.Compare;




import java.util.*;


/***java 中对象比较大小

 java 中对象比较大小有两种方法
 1：实现Comparable 接口 的 public int compareTo(T o) 方法；

 2：实现Comparator 接口 的 int compare(T o1, T o2)方法；
 ***/

/**
 * compareTo
 * compareTo(Object o)方法是java.lang.Comparable<T>接口中的方法，当需要对某个类的对象进行排序时，该类需要实现Comparable<T>接口的，必须重写public int compareTo(T o)方法。
 * 它强行将实现它的每一个类的对象进行整体排序-----称为该类的自然排序，实现此接口的对象列表和数组可以用Collections.sort(),和Arrays.sort()进行自动排序；
 * 也就是说，只要实现了这个接口的对象（数组）就相当于有了排序的能力，所以叫做comparable---可排序的，所以可以说这是一种内部排序的方式，通过实现它唯一的方法compareTo()。
 * 比如Hadoop中的MapReduce，Map函数和Reduce函数处理的 <key,value>,其中需要根据key对键值对进行排序，所以，key实现了WritableComparable<T>接口，实现这个接口可同时用于序列化和反序列化。WritableComparable<T>接口(用于序列化和反序列化)是Writable接口和Comparable<T>接口的组合；
 * compare
 * compare(Object o1,Object o2)方法是java.util.Comparator<T>接口的方法，它实际上用的是待比较对象的compareTo(Object o)方法。
 * 对于它，则是针对一些本身没有比较能力的对象（数组）为它们实现比较的功能，所以它叫做比较器，是一个外部的东西，通过它定义比较的方式，再传到Collection.sort()和Arrays.sort()中对目标排序，而且通过自身的方法compare()定义比较的内容和结果的升降序；
 */

public class CompareTest {
    public static void main(String[] args) {
        List list =new ArrayList();
        list.add(new Dept("2","研发部",23));
        list.add(new Dept("2","总公司",575));
        list.add(new Dept("2","总公司",565));
//      Collections.sort(list);
        Collections.sort(list, new Comparator(){

            public int compare(Object arg0, Object arg1) {
                // TODO Auto-generated method stub
                Dept dept1=(Dept)arg0;
                Dept dept2=(Dept)arg1;
                return dept1.compareTo(dept2);
            }

        });

        for (int i=0;i<list.size();i++){
            System.out.println((Dept)list.get(i));
        }


        Dept dept1=new Dept("2","研发部",23);
        Dept dept2=new Dept("2","kk",44);
        Set set=new TreeSet(new Comparator(){

            public int compare(Object arg0, Object arg1) {
                // TODO Auto-generated method stub
                return 0;
            }

        });
        set.add(dept1);
        set.add(dept2);


    }
}

class Dept implements Comparable{
    private String id;
    private String name;
    private long num;
    public Dept(String id,String name,long num){
        this.id=id;
        this.name=name;
        this.num=num;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public int compareTo(Object arg0) {
        Dept dept=(Dept) arg0;
        int i=0;
        i=this.id.compareTo(dept.id);
        if(i!=0){//部门id不相等
            return i;
        }else{//部门id相等
            i=this.name.compareTo(dept.name);
            if(i!=0){//部门名称不相等
                return i;
            }else{//部门名称不相等
                if(this.num>dept.num)return 1;
                else if(this.num<dept.num)return -1;
                else return 0;
            }
        }

    }
    public String toString() {
        // TODO Auto-generated method stub
        return this.id+"-->"+this.name+"-->"+this.num;
    }


}
