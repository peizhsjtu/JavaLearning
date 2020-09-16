package com.DeepCloneAndShallowClone;

import java.io.Serializable;

/**
 * 深克隆
 *   在Java语言里深复制一个对象，常常可以先使对象实现Serializable接口，然后把对象(实际上知识对象的一个拷贝)写到流里，再从流里读出来，便可以重建出来.
 *   这样做的前提是对象以及对象内部所引用到的对象都是可串行化的，否则，就需要仔细考察那些不可串行化的对象是否可设成transient，从而将之排除在复制过程之外.
 *
 */
public class DeepClone {

}

class Teacher3 implements Serializable{
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
}
class Student3 implements Serializable{
    private int age;
    private String name;
    private Teacher3 teacher;

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

    public Teacher3 getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher3 teacher) {
        this.teacher = teacher;
    }
}