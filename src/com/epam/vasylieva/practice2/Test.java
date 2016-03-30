package com.epam.vasylieva.practice2;


import java.awt.*;
import java.util.ArrayList;

public class Test {
    public static final ArrayList<Integer> f = new ArrayList<>();
    public static void main(String[] args){
        System.out.println("FF");
        Runtime r = Runtime.getRuntime();
        System.out.println(r.availableProcessors());
        f.add(4);
        System.out.println(f);
    }

}

