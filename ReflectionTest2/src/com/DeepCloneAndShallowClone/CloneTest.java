package com.DeepCloneAndShallowClone;

/**
 * Java中对象的克隆:
 * 1. 为了获取对象的一份拷贝，我们可以利用Object的clone()方法;
 * 2. 在派生类中覆盖基类的clone()方法，并声明为public(Object类中的clone()方法为protected的);
 * 3. 在派生类的clone()方法中，调用super.clone();
 * 4. 在派生类中实现Cloneable接口.
 *
 * 为什么在派生类中覆盖Object的clone()方法时，一定要调用super.clone()呢?
 *   在运行时刻，Object的clone识别出你要复制的是哪一个对象，然后为此对象分配空间，并进行对象的复制，将原始对象的内容
 *   一一复制到新对象的存储空间中.
 * 继承自java.lang.Object类的clone()方法是浅复制.
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student();

        student.setAge(20);
        student.setName("zhangsan");

        Student student2 = (Student) student.clone();

        System.out.println(student2.getName() + " : "+ student2.getAge());
        System.out.println("---------------------------------");

        student2.setName("lisi");
        System.out.println(student.getName() + " : " + student.getAge());
        System.out.println(student2.getName() + " : " + student2.getAge());
    }
}

class Student implements  Cloneable{
    private int age;

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        Object object = super.clone();
        return object;
    }
}