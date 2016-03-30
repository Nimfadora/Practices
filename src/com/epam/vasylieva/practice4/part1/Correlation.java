package com.epam.vasylieva.practice4.part1;

import com.epam.vasylieva.practice1.Main;

public class Correlation {

    public static double countCoefficient(int[] marksX, int[] marksY) {
        int sumX = 0;
        int sumY = 0;

        for (int i = 0; i < marksX.length; i++) {
            sumX += marksX[i];
            sumY += marksY[i];
        }

        int averageX = sumX / marksX.length;
        int averageY = sumY / marksY.length;
        int sum = sumX = sumY = 0;

        for (int i = 0; i < marksX.length; i++) {
            sum += Math.abs((marksX[i] - averageX) * (marksY[i] - averageY));
            sumX += Math.pow(marksX[i] - averageX, 2);
            sumY += Math.pow(marksY[i] - averageY, 2);
        }

        return sum / Math.pow(sumX*sumY, 0.5);
    }

    public static Pair [] countCorrelation(Student [] students){
        Pair[] res = new Pair[(students.length-1)*students.length/2];
        int k = 0;
        for(int i = 0; i<students.length; i++){
            for (int j = i+1; j < students.length; j++) {
                Pair pair = new Pair(students[i].getSurname(),
                                        students[j].getSurname(),
                                        countCoefficient(students[i].getMarks(), students[j].getMarks()));
                res[k++] = pair;
            }
        }
        return res;
    }
}
