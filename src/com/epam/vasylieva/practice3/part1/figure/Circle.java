package com.epam.vasylieva.practice3.part1.figure;


public class Circle extends Figure {
    private final String name = "Circle";
    private int r;
    private int x;
    private int y;

    public Circle(int y, int x, int r) {
        this.y = y;
        this.x = x;
        this.r = r;
    }


    @Override
    public double area() {
        return Math.pow(Math.PI * r, 2);
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
