package com.epam.vasylieva.practice3.part1.figure;


public class Rectangle extends Figure {
    private final String name = "Rectangle";
    private int a;
    private int b;
    private int x;
    private int y;

    public Rectangle(int a, int b, int x, int y) {
        this.a = a;
        this.b = b;
        this.x = x;
        this.y = y;
    }

    @Override
    public double area() {
        return a*b;
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
