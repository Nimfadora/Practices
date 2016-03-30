package com.epam.vasylieva.practice4.part1;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.MULTILINE;

public class Parser {
    private static final String TEXT = "Ivanov Ivan mail@\nPetrov Petr mail@";
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(?m)^(\\S+)(\\s+)(\\S+)(\\s+\\S+)$");
        Matcher m = p.matcher(TEXT);
        System.out.println(TEXT);
        while (m.find()){
            System.out.print(m.group(3) + m.group(2) + m.group(1) + m.group(4));
            System.out.println();
        }
    }
}
