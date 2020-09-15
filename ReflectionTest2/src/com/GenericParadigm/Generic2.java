package com.GenericParadigm;

public class Generic2<T> {
    private T[] fooArray;

    public T[] getFooArray(){
        return this.fooArray;
    }

    public void setFooArray(T[] fooArray) {
        this.fooArray = fooArray;
    }

    public static void main(String[] args) {
        Generic2<String> foo = new Generic2<String>();

        String[] str1 = {"hello", "world", "welcome"};

        String[] str2 = null;

        foo.setFooArray(str1);

        str2 = foo.getFooArray();

        for(String s:str2){
            System.out.println(s);
        }


    }
}
