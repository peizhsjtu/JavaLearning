package com.company.test1;

public class Student extends Person {

    public Student(){
        //super();
    }
    public Student(String name, Integer age){
        super(name,age);
    }
    private void method1(Integer age){
        System.out.println("private void method1"+age);

    }


}