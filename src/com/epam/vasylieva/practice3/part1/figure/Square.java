package com.epam.vasylieva.practice3.part1.figure;


public class Square extends Figure {
    private final String name = "Square";
    private int a;
    private int x;
    private int y;

    public Square(int a, int x, int y) {
        this.a = a;
        this.x = x;
        this.y = y;
    }

    @Override
    public double area() {
        return a*a;
    }

    @Override
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public String name() {
        return this.name;
    }
}
