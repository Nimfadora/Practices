package com.epam.vasylieva.practice5;

public class NumberConverter {
    private static final String[] roman = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
    private static final int[] decimal = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100};


    public static String decimal2Roman(int x) {
        StringBuilder s = new StringBuilder();
        for (int i = roman.length - 1; i >= 0; i--) {
            while (x >= decimal[i]) {
                s.append(roman[i]);
                x -= decimal[i];
            }
        }
        return s.toString();
    }

    public static int roman2Decimal(String s) {
        StringBuilder romanNumber = new StringBuilder(s);
        int decimalNumber = 0;
        while (romanNumber.length() > 0) {
            for (int i = roman.length - 2; i >= -1; i -= 2) {
                if (i > 0 && romanNumber.length() >= roman[i].length() && roman[i].equals(romanNumber.substring(0, roman[i].length()))) {
                    decimalNumber += decimal[i];
                    romanNumber.delete(0, roman[i].length());
                    break;
                } else if (romanNumber.length() >= roman[i + 1].length() && roman[i + 1].equals(romanNumber.substring(0, roman[i + 1].length()))) {
                    decimalNumber += decimal[i + 1];
                    romanNumber.delete(0, roman[i + 1].length());
                    break;
                }
            }
        }
        return decimalNumber;

    }


    public static void main(String[] args) {
        for (int i = 1; i < 100; i += 1) {
            String roman = decimal2Roman(i);
            System.out.print(roman + " ==> ");
            int decimal = roman2Decimal(roman);
            System.out.print(decimal + " ==> ");
            System.out.println(decimal2Roman(decimal));
        }
    }
}
