package com.epam.vasylieva.practice6.part1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    private final String FILE_NAME;

    private final String ENCODING;

    public Part1(String fileName, String encoding) {
        this.FILE_NAME = fileName;
        this.ENCODING = encoding;

    }

    public Part1() {
        this.FILE_NAME = "part1.txt";
        this.ENCODING = "Cp1251";
    }

    ;

    public static void main(String[] args) {
        Part1 p = new Part1();
        System.out.println(p.convert(p.read()));
    }

    private String read() {
        String s = "";
        try {
            s = new String(Files.readAllBytes(Paths.get("src/resources/" + FILE_NAME)), ENCODING);
        } catch (IOException e) {
            System.out.println("Some problems with file reading:" + e.getMessage());
        }
        return s;
    }

    public String convert(String s) {
        Pattern p = Pattern.compile("([A-Za-zА-Яа-я]{4,})");
        Matcher m = p.matcher(s);
        StringBuffer sb = new StringBuffer();

        while (m.find())
            m.appendReplacement(sb, m.group(1).toUpperCase());
        m.appendTail(sb);

        return sb.toString();
    }


}