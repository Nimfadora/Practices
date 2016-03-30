package com.epam.vasylieva.practice3.part3;

import java.util.NoSuchElementException;

public class StackImpl implements Stack {
    private Object[] stack;
    private int capacity = 0;

    public StackImpl(){
        stack = new Object[10];
    }

    @Override
    public boolean empty() {
        return capacity == 0;
    }

    @Override
    public Object peek() {
        return stack[capacity-1];
    }

    @Override
    public Object pop() {
        if(peek() != null)
            return stack[--capacity];
        throw new NoSuchElementException();
    }

    @Override
    public Object push(Object o) {
        if(stack.length == capacity)
            expand();
        return stack[capacity++] = o;
    }

    private void expand() {
        Object[] arr = new Object[capacity + capacity / 3];
        System.arraycopy(stack, 0, arr, 0, capacity);
        stack = arr;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("{");
        for (int i = 0; i < capacity; i++) {
            res.append("[").append(stack[i]).append("]");
        }
        res.append("}");
        return res.toString();
    }
}
