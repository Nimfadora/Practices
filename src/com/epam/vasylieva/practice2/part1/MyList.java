package com.epam.vasylieva.practice2.part1;

public interface MyList extends Iterable {
    void add(Object e);

    void clear();

    boolean remove(Object o);

    Object[] toArray();

    int size();

    boolean contains(Object o); //

    boolean containsAll(MyList c); //
}
