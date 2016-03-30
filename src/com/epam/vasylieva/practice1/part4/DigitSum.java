package com.epam.vasylieva.practice1.part4;

public class DigitSum {
    public static int getSum(int n){
        String num = String.valueOf(n);
        int res = 0;
        for (int i = 0; i<num.length(); i++) {
           res += num.charAt(i)- '0';
        }
        return res;
    }
}
