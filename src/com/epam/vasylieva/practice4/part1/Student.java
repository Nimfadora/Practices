package com.epam.vasylieva.practice4.part1;


public class Student {
    private int [] marks;
    private String surname;
    public Student(String surname, String[] arr){
        marks = parseMarks(arr);
        this.surname = surname;
    }

    public int[] getMarks() {
        return marks;
    }

    public String getSurname() {
        return surname;
    }

    private int[] parseMarks(String[] arr){
        int []marks = new int[arr.length];
        for(int i = 0; i<arr.length; i++)
            marks[i] = (arr[i].equals("")) ? 0 : Integer.parseInt(arr[i]);
        return marks;
    }
}
