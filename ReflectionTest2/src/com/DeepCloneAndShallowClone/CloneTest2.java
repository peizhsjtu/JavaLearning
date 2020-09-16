package com.DeepCloneAndShallowClone;

/**
 * 浅克隆
 */
public class CloneTest2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher teacher = new Teacher();
        teacher.setName("Teacher zhang");
        teacher.setAge(40);

        Student2 s1 = new Student2();
        s1.setAge(20);
        s1.setName("zhangsan");
        s1.setTeacher(teacher);
        System.out.println(s1.getName()+" : " + s1.getAge() +" " + s1.getTeacher().getName() + " : "+s1.getTeacher().getAge());

        Student2 s2 = (Student2) s1.clone();
        System.out.println(s2.getName() +" : " + s2.getAge() + " "+ s2.getTeacher().getName()+ " : " + s2.getTeacher().getAge());

        System.out.println("----------------------");
        
        s2.getTeacher().setName("Teacher li");
        System.out.println(s1.getName()+" : " + s1.getAge() +" " + s1.getTeacher().getName() + " : "+s1.getTeacher().getAge());
        System.out.println(s2.getName() +" : " + s2.getAge() + " "+ s2.getTeacher().getName()+ " : " + s2.getTeacher().getAge());

    }
}


class Teacher implements Cloneable{
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

class Student2 implements Cloneable{
    private int age;
    private String name;
    private Teacher teacher;

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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
