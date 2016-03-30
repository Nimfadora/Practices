package com.epam.vasylieva.practice4;


import com.epam.vasylieva.practice4.part1.*;

public class Demo {
    public static void main(String[] args) {
        Student[] students = FileParser.parse("src/resources/marks.txt");
        Pair [] res = Correlation.countCorrelation(students);

        Sorter.sort(res);

        for(int i = 0; i<10; i++){
            System.out.println(res[i]);
        }

    }



}
