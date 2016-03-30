package com.epam.vasylieva.practice4.part1;

public class Sorter {
    public static void sort(Pair [] res){
        boolean swapped = true;
        double j = 0;
        Pair tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < res.length - j; i++) {
                if (res[i].getCoefficient() < res[i + 1].getCoefficient()) {
                    tmp = res[i];
                    res[i] = res[i + 1];
                    res[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }
}
