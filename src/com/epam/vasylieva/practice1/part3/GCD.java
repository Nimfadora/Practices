package com.epam.vasylieva.practice1.part3;

public class GCD {
   public static int getGCD(int a, int b){
       if(a == 0){
           return b;
       }
       if(b == 0)
           return a;

       return (a>b) ? getGCD(b, a%b) : getGCD(a, b%a);
   }
}
