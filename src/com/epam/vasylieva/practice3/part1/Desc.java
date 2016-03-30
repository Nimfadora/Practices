package com.epam.vasylieva.practice3.part1;


import com.epam.vasylieva.practice3.part1.figure.Figure;

public class Desc {
    private Figure[] figures;
    private int capacity;

    public Desc() {
        figures = new Figure[10];
    }

    public double area() {
        int area = 0;
        for (int i = 0; i < capacity; i++) {
            area += figures[i].area();
        }
        return area;
    }

    public void move(double dx, double dy) {
        for (int i = 0; i < capacity; i++) {
            figures[i].move(dx, dy);
        }
    }

    public void printNames() {
        System.out.print("{");
        for (int i = 0; i < capacity; i++) {
            System.out.print(figures[i].name() + ", ");
        }
        System.out.println("}");
    }

    public void add(Figure f) {
        if (figures.length == capacity)
            expand();
        figures[capacity++] = f;
    }

    public void add(Desc desc) {
        capacity += desc.capacity;
        if (figures.length < capacity)
            expand();
        System.arraycopy(desc.figures, 0, figures, capacity, desc.capacity);
    }

    public void remove(int index) {
        if (index < 0 || index > capacity - 1)
            throw new IndexOutOfBoundsException();

        System.arraycopy(figures, index + 1, figures, index, capacity - index);
        capacity--;
    }

    private void expand() {
        Figure[] arr = new Figure[capacity + capacity / 3];
        System.arraycopy(figures, 0, arr, 0, capacity);
        figures = arr;
    }

}
