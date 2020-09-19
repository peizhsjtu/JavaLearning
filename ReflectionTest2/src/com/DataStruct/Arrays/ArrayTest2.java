package com.DataStruct.Arrays;

import java.util.Arrays;

public class ArrayTest2 {
    public static void main(String[] args) {
        Student s1 = new Student("lihua" , "shanghai");
        Student s2 = new Student("lihua", "shanghai");
        Student s3 = new Student("wangmazi" ,"beijing");
        Student s4 = new Student("wangmazi", "beijing");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        Student[] student1 = {s1, s3};
        Student[] student2 = {s2, s4};

        System.out.println(Arrays.equals(student1, student2));

        System.out.println("------------------------------");

        String str1 = "abc";
        String str2 = "def";

        System.out.println(str1.concat(str2));

    }
}
class Student{
    String name;
    String address;

    public Student(String name, String address){
        this.name = name;
        this.address = address;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object student2){
        Student student = (Student) student2;
        return student2 == null ? false : (getName().equals(((Student) student2).getName()) && getAddress().equals(student.getAddress()));
    }
}
