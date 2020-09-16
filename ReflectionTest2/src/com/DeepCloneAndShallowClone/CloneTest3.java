package com.DeepCloneAndShallowClone;

/**
 * 深克隆
 */
public class CloneTest3 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher2 teacher = new Teacher2();
        teacher.setName("Teacher zhang");
        teacher.setAge(40);

        Student22 s1 = new Student22();
        s1.setAge(20);
        s1.setName("zhangsan");
        s1.setTeacher(teacher);
        System.out.println(s1.getName()+" : " + s1.getAge() +" " + s1.getTeacher().getName() + " : "+s1.getTeacher().getAge());

        Student22 s2 = (Student22) s1.clone();
        System.out.println(s2.getName() +" : " + s2.getAge() + " "+ s2.getTeacher().getName()+ " : " + s2.getTeacher().getAge());

        System.out.println("----------------------");
        
        s2.getTeacher().setName("Teacher li");
        System.out.println(s1.getName()+" : " + s1.getAge() +" " + s1.getTeacher().getName() + " : "+s1.getTeacher().getAge());
        System.out.println(s2.getName() +" : " + s2.getAge() + " "+ s2.getTeacher().getName()+ " : " + s2.getTeacher().getAge());

    }
}


class Teacher2 implements Cloneable{
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
        return super.clone();
    }

}

class Student22 implements Cloneable{
    private int age;
    private String name;
    private Teacher2 teacher;

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

    public Teacher2 getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher2 teacher) {
        this.teacher = teacher;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{

        Student22 student2 = (Student22) super.clone();
        student2.setTeacher((Teacher2) student2.getTeacher().clone());
        return student2;
    }
}
