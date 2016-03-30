package com.epam.vasylieva.practice3.part2;


import java.util.NoSuchElementException;

public class ArrayHelper {

    public static Iterator iterator(Object[] ar) {
        return new Iterator() {
            protected int cursor = 0;

            @Override
            public void moveToStart() {
                cursor = 0;
            }

            @Override
            public void moveToEnd() {
                cursor = ar.length;
            }

            @Override
            public boolean hasNext() {
                return !(cursor == ar.length);
            }

            @Override
            public boolean hasPrevious() {
                return cursor > 0;
            }

            @Override
            public Object next() {
                if (this.hasNext()) {
                    return ar[cursor++];
                }
                throw new NoSuchElementException();
            }

            @Override
            public Object previous() {
                if (this.hasPrevious()) {
                    return ar[--cursor];
                }
                throw new NoSuchElementException();
            }
        };
    }

}
