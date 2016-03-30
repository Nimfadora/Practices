package com.epam.vasylieva.practice5.part1;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfoConverter {
    public static final String TEXT = "ivanov;Ivan Ivanov;ivanov@mail.ru\n" +
            "petrov;Petr Petrov;petrov@google.com\n" +
            "obama;Barack Obama;obama@google.com\n" +
            "bush;George Bush;bush@mail.ru";

    public String convert1() {
        Pattern p = Pattern.compile("([a-zA-Z0-9]+);([a-zA-Z0-9\\s]+);([a-z@\\.]+)");
        Matcher m = p.matcher(TEXT);
        return m.replaceAll("$1 == > $3");
    }

    public String convert2() {
        Pattern p = Pattern.compile("([a-zA-Z0-9]+);([a-zA-Z0-9\\s]+);([a-z@\\.]+)");
        Matcher m = p.matcher(TEXT);
        return m.replaceAll("$2 (email: $3)");
    }

    public String convert3(){
        Pattern p = Pattern.compile("([a-zA-Z0-9]+);([a-zA-Z0-9\\s]+);([a-z]+)@([\\.a-z]+)");
        Matcher m = p.matcher(TEXT);
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        while (m.find()){
            if(sb.indexOf(m.group(4)) == -1) {
                Pattern mail = Pattern.compile("^(([a-zA-Z0-9]+);([a-zA-Z0-9\\s]+);([a-z]+)@" + m.group(4) + ")$", Pattern.MULTILINE);
                Matcher matcher = mail.matcher(TEXT);
                flag = true;
                while (matcher.find()) {
                    if (flag) {
                        sb.append(m.group(4)).append(" ==> ").append(matcher.group(2));
                        flag = false;
                    }else
                        sb.append(", ").append(matcher.group(2));
                }
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    public String convert4() {
        Pattern p = Pattern.compile("^([a-zA-Z0-9]+);([a-zA-Z0-9\\s]+);([a-z@\\.]+)$", Pattern.MULTILINE);
        Matcher m = p.matcher(TEXT);
        StringBuffer s = new StringBuffer("");
        while (m.find()){
            m.appendReplacement(s, "$1;$2;$3;" + (int) (Math.random()*8999 + 1000));
        }
        return s.toString();
    }

    public static void main(String[] args) {
        InfoConverter converter = new InfoConverter();
        System.out.println(converter.convert3());
    }
}
