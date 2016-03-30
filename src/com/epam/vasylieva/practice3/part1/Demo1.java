package com.epam.vasylieva.practice3.part1;

import com.epam.vasylieva.practice3.part1.figure.Circle;
import com.epam.vasylieva.practice3.part1.figure.Figure;
import com.epam.vasylieva.practice3.part1.figure.Rectangle;
import com.epam.vasylieva.practice3.part1.figure.Square;

public class Demo1 {
    public static void main(String[] args) {
        Figure circle = new Circle(2, 2, 2);
        Figure rectangle = new Rectangle(3, 3, 3, 3);
        Figure square = new Square(4, 4, 4);
        Desc container = new Desc();

        container.add(circle);
        container.add(rectangle);
        container.add(square);

        System.out.println("area = "+container.area());

        container.move(3, 3);

        System.out.println("area = "+container.area());
        container.printNames();

        System.out.println("remove idx = 2");
        container.remove(2);
        container.printNames();

        System.out.println();
        System.out.println("remove idx = 2");
        try {
            container.remove(2);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Index 2 is out of bounds");
        }
        container.printNames();

        System.out.println();
        System.out.println("remove idx = 0");
        container.remove(0);
        container.printNames();

    }
}
