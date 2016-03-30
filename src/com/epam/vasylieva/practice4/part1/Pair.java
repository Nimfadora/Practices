package com.epam.vasylieva.practice4.part1;

public class Pair {
    private String firstName;
    private String secondName;
    private double coefficient;

    public Pair(String firstName, String secondName, double coefficient) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }

    @Override
    public String toString() {
        return firstName + " " + secondName + " " + Math.round(coefficient * 100.0) / 100.0;
    }
}
