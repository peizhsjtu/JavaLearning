package com.company.test1;

public class Person {
    String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }
    private void setName(String name,Integer integer){
        System.out.println("@@@@@@@@"+name+integer);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public Person(){

    }
    public String method2(){
        return "private string method2";
    }
    private Object method3(String name,int age){
        Person person = new Person(name,age);
        return person;
    }
}
