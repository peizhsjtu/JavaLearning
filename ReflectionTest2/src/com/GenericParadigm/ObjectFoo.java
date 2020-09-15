package com.GenericParadigm;

public class ObjectFoo {
    private Object foo;

    public Object getFoo() {
        return foo;
    }

    public void setFoo(Object foo) {
        this.foo = foo;
    }

    public static void main(String[] args) {
        ObjectFoo foo1 = new ObjectFoo();
        ObjectFoo foo2 = new ObjectFoo();

        foo1.setFoo(new Boolean(false));
        foo2.setFoo(new Integer(10));

        Boolean b = (Boolean) foo1.getFoo();
        Integer i = (Integer) foo2.getFoo();

        System.out.println(b.getClass() + " " + b);
        System.out.println(i.getClass() + " " + i);

        System.out.println("--------------------");
/*
因此用Object会出错，编译没出错，运行出错
 */
        ObjectFoo foo3 = new ObjectFoo();
        foo3.setFoo(new Boolean(false));
        String str = (String) foo3.getFoo();
    }
}
