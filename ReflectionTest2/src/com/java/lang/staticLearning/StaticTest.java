package com.java.lang.staticLearning;

/**
 * https://twocups.cn/index.php/2020/01/22/16/
 * 整合版：
 * 父类静态变量
 * 父类静态代码块
 * 子类静态变量
 * 子类静态代码块
 * main
 * 详细版：
 * 父类静态代码块（不存在）  //“private static parent a=new parent()”中父类静态变量步骤
 * 父类普通代码块  //“private static parent a=new parent()”中父类静态变量步骤
 * 父类构造方法  //“private static parent a=new parent()”中父类静态变量步骤
 * 父类静态代码块
 * 父类静态代码块（不存在）  //“private static sub b = new sub()”中子类静态变量步骤
 * 父类普通代码块  //“private static sub b = new sub()”中子类静态变量步骤
 * 父类构造方法  //“private static sub b = new sub()”中子类静态变量步骤
 * 子类静态代码块（不存在）  //“private static sub b = new sub()”中子类静态变量步骤
 * 子类普通代码块  //“private static sub b = new sub()”中子类静态变量步骤
 * 子类构造方法  //“private static sub b = new sub()”中子类静态变量步骤
 * 子类静态代码块
 * main
 * 父类静态变量（不存在） //“main”中“new parent()”步骤
 * 父类静态代码块（不存在）  //“main”中“new parent()”步骤
 * 父类普通代码块  //“main”中“new parent()”步骤
 * 父类构造方法  //“main”中“new parent()”步骤
 * parent-sub
 * 父类静态变量（不存在） //“main”中“new sub()”步骤
 * 父类静态代码块（不存在）  //“main”中“new sub()”步骤
 * 父类普通代码块  //“main”中“new sub()”步骤
 * 父类构造方法  //“main”中“new sub()”步骤
 * 子类静态变量（不存在） //“main”中“new sub()”步骤
 * 子类静态代码块（不存在）  //“main”中“new sub()”步骤
 * 子类普通代码块  //“main”中“new sub()”步骤
 * 子类构造方法  //“main”中“new sub()”步骤
 */

//父类parent
class parent {
    private static parent a=new parent(); //父类静态变量
    static{
        System.out.println("父类静态代码块");
    }
    {
        System.out.println("父类普通代码块");
    }
    public parent(){
        System.out.println("父类构造方法");
    }
}
//子类sub
class sub extends parent{
    private static sub b = new sub(); //子类静态变量
    static{
        System.out.println("子类静态代码块");
    }
    {
        System.out.println("子类普通代码块");
    }
    public sub(){
        System.out.println("子类构造方法");
    }
    public static void main(String[] args) {
        System.out.println("main");
        new parent();
        System.out.println("parent-sub");
        new sub();
    }
}