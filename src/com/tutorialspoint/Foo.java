package com.tutorialspoint;

public class Foo {
    public Foo(Bar bar, Baz baz) {
        System.out.println("Foo: Constructor(Bar bar, Baz baz)");
    }

    public Foo(int year, String name) {
        System.out.println("Foo: Constructor(int year "+ Integer.toString(year)+ ", String name "+ name +")");
    }

    public void init(){
        System.out.println("Foo: init()");
    }

    public void cleanUp(){
        System.out.println("Foo: cleanUp()");
    }
}
