package com.epam.vasylieva.practice1;

import com.epam.vasylieva.practice1.part2.Summarizer;
import com.epam.vasylieva.practice1.part3.GCD;
import com.epam.vasylieva.practice1.part4.DigitSum;
import com.epam.vasylieva.practice1.part5.ExelTools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.Pipe;

public class Main {
    public static void main(String[] args) {
        int a, b;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                while (true) {
                    try {
                        System.out.print("a = ");
                        a = Integer.parseInt(br.readLine());
                        System.out.print("b = ");
                        b = Integer.parseInt(br.readLine());
                    } catch (NumberFormatException e) {
                        System.out.println("invalid number format, please try again");
                        continue;
                    }
                    break;
                }
                System.out.println("a + b = "+ Summarizer.sum(a, b));
                System.out.println("gcd(a,b) = "+ GCD.getGCD(a, b));
                System.out.println("digitSum(a) = "+ DigitSum.getSum(a));
                System.out.println("digitSum(b) = "+ DigitSum.getSum(b));
                System.out.println("cell № 53 = "+ ExelTools.digits2chars(53));
                System.out.println("№ of cell AZ = "+ ExelTools.chars2digits("AZ"));
                System.out.println("№ of cell AAZ = "+ ExelTools.chars2digits("AAZ"));
                System.out.println("Next to AAZ = "+ ExelTools.rightColumn("AAZ"));
                System.out.println("Do you want to continue? y/n");
                if ( br.readLine().equals("n"))
                    break;
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
