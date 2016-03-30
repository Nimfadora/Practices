package com.epam.vasylieva.practice4.part1;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileParser {
    private static String read(String path){
        String s = "";
        try {
            s = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Some problems with file reading:" + e.getMessage());
        }
        return s;
    }

    public static Student[] parseRegExp(String filePath){
        final String TEXT = read(filePath);
        ArrayList<Student>lst = new ArrayList();
        Pattern p = Pattern.compile("([A-Za-z]+)\\s([A-Za-z]+);((([0-9]*);?)+)");
        Matcher m = p.matcher(TEXT);

        while (m.find()){
            Student s = new Student(m.group(1), m.group(3).split(";", -1));
            lst.add(s);
        }
        Student[] res = new Student[lst.size()];

        for (int i = 0; i<lst.size(); i++){
            res[i] = lst.get(i);
        }
        return res;
    }

    public static Student[] parse(String filePath){
        ArrayList<Student>lst = new ArrayList();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))){
            String line;
            while ((line = reader.readLine()) != null) {
                String surname = line.substring(0, line.indexOf(';')).split(" ")[0];
                String[] marks = line.substring(line.indexOf(";")+1).split(";", -1);
                Student s = new Student(surname, marks);
                lst.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        Student[] res = new Student[lst.size()];

        for (int i = 0; i<lst.size(); i++){
            res[i] = lst.get(i);
        }
        return res;
    }
}
