package de.luca.uebungsaufgaben.uebungsblatt07;

public class Aufgabe1 {

    private static void f(int n) {
        if (n <= 0) {
            System.out.println("Abbruch in f, Wert: " + n);
            return;
        }
        g(n + 1);
    }

    private static void g(int n) {
        if (n <= 0) {
            System.out.println("Abbruch in g, Wert: " + n);
        }
        f(n - 2);
    }

    private static void startInF(int n) {
        if (n <= 0) {
            System.out.println("Abbruch in f, Wert: " + n);
            return;
        }
        /*
        n = n +1;
        if (n <= 0) {
            System.out.println("Abbruch in g, Wert: " + n);
        }
        startInF(n - 2);
        */
        startInF(n - 1);
    }

    private static void startInG(int n) {
        if (n <= 0) {
            System.out.println("Abbruch in g, Wert: " + n);
        }
        n = n - 2;
        if (n <= 0) {
            System.out.println("Abbruch in f, Wert: " + n);
            return;
        }
        startInG(n + 1);
    }
}

