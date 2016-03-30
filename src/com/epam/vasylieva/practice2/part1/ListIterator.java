package com.epam.vasylieva.practice2.part1;

import java.util.Iterator;

public interface ListIterator extends Iterator<Object> {
    boolean hasPrevious();
    Object previous();
    void set(Object e);
    void remove();
}
