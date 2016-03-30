package com.epam.vasylieva.practice3;



class A{
    {
        System.out.println("block A");
    }
    static {
        System.out.println("static block A");
    }
    public A(){
        System.out.println("constructor A");
    }
}

class B extends A{
    {
        System.out.println("block B");
    }
    static {
        System.out.println("static block B");
    }
    public B(){
        System.out.println("constructor B");
    }
}

class C extends B{
    {
        System.out.println("block C");
    }
    static {
        System.out.println("static block C");
    }
    public C(){
        System.out.println("constructor C");
    }
}


public class Test {
    public static void main(String[] args) {
        A a = new C();
    }
}
