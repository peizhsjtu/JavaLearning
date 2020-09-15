package com.methodpassargument;

//关于方法参数传递的总结：对于Java中的方法参数传递，无论传递的是原生数据类型还是引用类型，统一是传值(pass by value)，对于基本数据类型，传递的是字面量；对于引用类型，传递的是地址信息，地址也是值，因此指向同一个对象。Java中没有传引用(pass by reference)的概念。
public class ParamTest2 {
    //引用是把地址传递，传递的对象是存放在堆(heap)里面，基本数据类型是传递值，其存放在栈里面，是局部变量
    public static void main(String[] args) {
        ParamTest2 pt2 = new ParamTest2();
        C c = new C();
        int a = 1;
        c.changeInt(a);
        System.out.println(a);
    }

}

class C{
    void changeInt(int a){
        a++;
    }
}
