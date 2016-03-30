package com.epam.vasylieva.practice3.part1.figure;


public abstract class Figure {
    private final String name = "Figure";

    public abstract double area();
    public abstract void move(double dx, double dy);
    public String name() {
        return this.name;
    }
}
