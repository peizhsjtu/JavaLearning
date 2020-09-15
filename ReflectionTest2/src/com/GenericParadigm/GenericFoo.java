package com.GenericParadigm;

/**
 *
 * @param <T> 代表类型信息
 *
 *1. 使用泛型编译就能发现问题；
 *
 * 2. 所谓泛型就是变量类型的参数化；
 */
public class GenericFoo<T> {
    private T foo;

    public T getFoo() {
        return foo;
    }

    public void setFoo(T foo) {
        this.foo = foo;
    }

    public static void main(String[] args) {
        GenericFoo<Boolean> foo1 = new GenericFoo<Boolean>();
        foo1.setFoo(new Boolean(true));
        System.out.println(foo1.getFoo().getClass());

        System.out.println("-----------------------");

        GenericFoo<Integer> foo2 = new GenericFoo<>();
        foo2.setFoo(new Integer(1000));
        System.out.println(foo2.getFoo().getClass());

        System.out.println("-----------------------");

        GenericFoo a = new GenericFoo();
        a.setFoo("hello");
        String str = (String) a.getFoo();
        System.out.println(str);
    }
}
