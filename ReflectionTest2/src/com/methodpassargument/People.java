package com.methodpassargument;

public class People {
    int age;

    public void change(int i){
        i++;
    }

    public void change2(People p){
        p = new People();
        p.age++;
    }

    public void change3(People p, int i){
        p.age++;
        i++;
    }

    public static void main(String[] args) {

        People people = new People();
        int a = 0;
        people.change(people.age);
        System.out.println(people.age);
        //0

        People people2 = new People();
        people2.change2(people);
        System.out.println(people2.age);
        //0

        People people3 = new People();
        people.change3(people, people.age);
        System.out.println(people.age);
        //1

    }
}
