package com.epam.vasylieva.practice4;


public class Test {

    public static void main(String[] args) {
        try{
            try {
                throw new NullPointerException();
            }finally {
                System.out.println("2");
                return;
            }
        }finally {
            System.out.println(1);
            return;
        }

    }
}

class A<T> {
    int a = 7;

    int getA() {
        return a;
    }

    public void print() {
        System.out.println("hello");
    }
}

