package com.epam.vasylieva.practice1.part5;


public class ExelTools {
    public static int chars2digits(String number) {
        int res = 0;
        for (int i = 0; i < number.length(); i++) {
            res += (number.charAt(i) - 'A' + 1) * Math.pow(26, number.length() - i - 1);
        }
        return res;
    }

    public static String digits2chars(int number) {
        String res = "";
        while (number > 0) {
            if(number%26 == 0) {
                res = (char) (26 + 'A' - 1) + res;
                number /= 27;
            }else {
                res = (char) (number % 26 + 'A' - 1) + res;
                number /= 26;
            }
        }
        return res;
    }

    public static String rightColumn(String number) {
        return digits2chars(chars2digits(number)+1);
    }
}
