package com.epam.vasylieva.practice5.part2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Seeker {

    public final static String TEXT = "When I was younger, so much younger than today " +
            "I never needed anybody's help in any way " +
            "But now these days are gone, I''m not so self-assured " +
            "Now I find I've changed my mind " +
            "I've opened up the doors";

    public String findMin() {
        Pattern p = Pattern.compile("([a-zA-Z]+)");
        Matcher m = p.matcher(TEXT);
        int s = 0;
        while (m.find())
            if (s == 0 || s > m.group(1).length())
                s = m.group(1).length();


        p = Pattern.compile("[^a-zA-Z]([a-zA-Z]{"+s+"})[^a-zA-Z]|^([a-zA-Z]{"+s+"})[^a-zA-Z]");
        m = p.matcher(TEXT);
        StringBuilder sb = new StringBuilder("Min: ");
        while (m.find()){
            if(sb.indexOf(m.group(1)) == -1) {
                sb.append(m.group(1)).append(" ");
            }
        }
        return sb.toString();
    }

    public String findMax() {
        Pattern p = Pattern.compile("([a-zA-Z]+)");
        Matcher m = p.matcher(TEXT);
        int b = 0;
        while (m.find())
            if(b == 0 || b<m.group(1).length())
                b = m.group(1).length();
        p = Pattern.compile("[^a-zA-Z]([a-zA-Z]{"+b+"})[^a-zA-Z]|^([a-zA-Z]{"+b+"})[^a-zA-Z]");
        m = p.matcher(TEXT);
        StringBuilder sb = new StringBuilder("Max: ");
        while (m.find()){
            if(sb.indexOf(m.group(1)) == -1) {
                sb.append(m.group(1)).append(" ");
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        Seeker s = new Seeker();
        System.out.println(s.findMin());
        System.out.println(s.findMax());
    }
}
