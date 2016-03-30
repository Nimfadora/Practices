package com.epam.vasylieva.practice2.part1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyListImpl implements MyList,  ListIterable {
    private Object[] lst;
    private int capacity = 0;

    private class IteratorImpl implements Iterator<Object> {

        protected int cursor = 0;
        protected boolean lastRect = false;

        public boolean hasNext() {
            return cursor < capacity;
        }

        public Object next() {
            if (this.hasNext()) {
                lastRect = true;
                return lst[cursor++];
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (cursor > 0 && cursor <= capacity) {
                MyListImpl.this.remove(lst[cursor-1]);
            }else {
                throw new IllegalStateException();
            }

        }

    }

    private class ListIteratorImpl extends IteratorImpl implements ListIterator {

        @Override
        public boolean hasPrevious() {
            return this.cursor>0;
        }

        @Override
        public Object previous() {
            if (this.hasPrevious()) {
                lastRect = true;
                return lst[--cursor];
            }
            throw new NoSuchElementException();
        }

        @Override
        public void set(Object e) {
            if(lastRect){
                if (cursor > 0 && cursor <= capacity) {
                    lst[cursor] = e;
                }else {
                    throw new IllegalStateException();
                }
            }
        }

        @Override
        public void remove() {
            if(lastRect){
                super.remove();
            }
        }
    }

    public MyListImpl() {
        lst = new Object[10];
    }


    @Override
    public void add(Object e) {
        if (capacity == lst.length) {
            expand();
        }
        lst[capacity++] = e;
    }


    @Override
    public void clear() {
        lst = new Object[10];
        capacity = 0;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < capacity; i++) {
                if (lst[i] == null) {
                    System.arraycopy(lst, i + 1, lst, i, capacity - i);
                    lst[--capacity] = null;
                    return true;
                }
            }
        } else {
            for (int i = 0; i < capacity; i++) {
                if (o.equals(lst[i])) {
                    System.arraycopy(lst, i + 1, lst, i, capacity - i);
                    lst[--capacity] = null;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[capacity];
        System.arraycopy(lst, 0, arr, 0, capacity);
        return arr;
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < capacity; i++) {
                if (lst[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < capacity; i++) {
                if (o.equals(lst[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(MyList c) {
        Object[] arr = c.toArray();
        for (int i = 0; i < capacity; i++) {
            if (!contains(arr[i]))
                return false;
        }
        return true;
    }

    private void expand() {
        Object[] arr = new Object[capacity + capacity / 3];
        System.arraycopy(lst, 0, arr, 0, capacity);
        lst = arr;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("{");
        for (int i = 0; i < capacity; i++) {
            res.append("[").append(lst[i]).append("]");
        }
        res.append("}");
        return res.toString();
    }

    @Override
    public Iterator iterator() {
        return new IteratorImpl();
    }


    @Override
    public ListIterator listIterator() {
        return new ListIteratorImpl();
    }


}
