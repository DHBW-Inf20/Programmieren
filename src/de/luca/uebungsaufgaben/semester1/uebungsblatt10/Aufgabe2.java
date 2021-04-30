package de.luca.uebungsaufgaben.semester1.uebungsblatt10;

import java.util.Arrays;
import java.util.List;

public class Aufgabe2 {

    public static void main(String[] args) {
        List<Double> list = Arrays.asList(1.5, 2.3, 3.4, 7.8);
        double sum = 0.0;
        for (double x : list) sum += x;
        System.out.format("Sum: %6.2f%n", sum);
    }
}
