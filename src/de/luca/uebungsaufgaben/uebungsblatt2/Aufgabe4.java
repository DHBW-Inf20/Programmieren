package de.luca.uebungsaufgaben.uebungsblatt2;

import java.util.Arrays;

public class Aufgabe4 {

    public static void main(String[] args) {
        int[] unsortedList = {4, 8, 99, 136, 42, 3, 7};
        System.out.println(Arrays.toString(unsortedList));
        System.out.println("Max: " + findMax(unsortedList));
    }

    public static int findMax(int[] anUnsortedList){
        int max = anUnsortedList[0];

        for (int number: anUnsortedList){
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
}
