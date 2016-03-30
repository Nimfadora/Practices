package com.epam.vasylieva.practice5.part3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class toUpperCase {
    public static final String TEXT = "Мама мыла раму\n" +
            "Папа мыл машину";
    public static String toUpper(){
        Pattern p = Pattern.compile("(\\s[а-я]|^[а-я])", Pattern.MULTILINE);

        Matcher m = p.matcher(TEXT);
        StringBuffer s = new StringBuffer();

        while (m.find())
            m.appendReplacement(s, m.group(1).toUpperCase());
        m.appendTail(s);

        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(toUpper());
    }
}
