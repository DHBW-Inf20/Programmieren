package de.luca.uebungsaufgaben.semester1.uebungsblatt02;

public class Aufgabe5 {

    public static void main(String[] args) {
        long a = 5072481;
        long b = 54228615;

        System.out.println("Größter gemeinsamer Teiler von " + a + " und " + b + ":");
        System.out.println("Iterativ: " + euclideanAlgorithmIterative(a, b));
        System.out.println("Rekursiv: " + euclideanAlgorithmRecursive(a, b));
        System.out.println("Iterativ modern: " + modernEuclideanAlgorithmIterative(a, b));
        System.out.println("Rekursiv modern: " + modernEuclideanAlgorithmRecursive(a, b));
    }

    public static long euclideanAlgorithmIterative(long a, long b) {
        if (a < 0 || b < 0) return 0;
        if (a == 0) return b;

        while (b != 0) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public static long euclideanAlgorithmRecursive(long a, long b) {
        if (a < 0 || b < 0) return 0;
        if (b == 0) return a;
        if (a == 0) return b;

        if (a > b) return euclideanAlgorithmRecursive(a - b, b);
        return euclideanAlgorithmRecursive(a, b - a);
    }

    public static long modernEuclideanAlgorithmIterative(long a, long b) {
        if (a < 0 || b < 0) return 0;
        if (b == 0) return a;

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static long modernEuclideanAlgorithmRecursive(long a, long b) {
        if (a < 0 || b < 0) return 0;
        if (b == 0) return a;
        if (a == 0) return b;

        if (a > b) return modernEuclideanAlgorithmRecursive(a % b, b);
        return modernEuclideanAlgorithmRecursive(a, b % a);
    }
}
