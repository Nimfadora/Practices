package com.epam.vasylieva.practice3.part2;

public class Demo2 {
    public static void main(String[] args) {
        Object[] ar = {1, 2, 3};
        Iterator it = ArrayHelper.iterator(ar);

        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        } // 1 2 3
        System.out.println();
        it.moveToStart();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        } // 1 2 3
        System.out.println();
        while (it.hasPrevious()) {
            System.out.print(it.previous() + " ");
        } // 3 2 1
        System.out.println();
        it.moveToEnd();
        while (it.hasPrevious()) {
            System.out.print(it.previous() + " ");
        } // 3 2 1
    }
}