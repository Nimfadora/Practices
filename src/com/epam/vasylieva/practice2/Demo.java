package com.epam.vasylieva.practice2;

import com.epam.vasylieva.practice2.part1.ListIterator;
import com.epam.vasylieva.practice2.part1.MyListImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Demo d = new Demo();
        d.checkIterator();
//        MyListImpl con = new MyListImpl();
//        con.add("A");
//        con.add("B");
//        con.add(433);
//        con.add(888);
//        con.add(672);
//        con.add(new Object());
//
//        System.out.println(con.contains("A"));
//        System.out.println(con.contains(433));
//        System.out.println(con.contains(null));
//        System.out.println(con.contains(888));
//        System.out.println(con.contains(872));
//
//        System.out.println("____________________________");
//
//        System.out.println(con.size());
//
//        System.out.println(con.toString());
//
//        System.out.println("____________________________");
//
//        System.out.println(con.remove("A"));
//        System.out.println(con.remove("b"));
//        System.out.println(con.remove(889));
//        System.out.println(con.remove(888));
//
//        System.out.println("____________________________");
//
//        System.out.println(con.toString());

    }

    private void checkIterator(){
        MyListImpl con = new MyListImpl();

        con.add("A");
        con.add("B");
        con.add(433);
        con.add(888);
        con.add(672);
        con.add(new Object());

        for (Object o : con) {
            System.out.println(o);
        }

        ListIterator it = con.listIterator();
        it.next();
        it.remove();
        System.out.println(it.hasPrevious());
        it.set(12);
        it.previous();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
