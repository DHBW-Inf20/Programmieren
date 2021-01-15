package de.luca.uebungsaufgaben.uebungsblatt07;

public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println(isPrimeNumber(-1));
        System.out.println(isPrimeNumber(0));
        System.out.println(isPrimeNumber(1));
        System.out.println(isPrimeNumber(2));
        System.out.println(isPrimeNumber(3));
        System.out.println(isPrimeNumber(4));
        System.out.println(isPrimeNumber(4783));
    }

    private static boolean isPrimeNumber(int p) {
        if (p <= 1) return false;
        return isPrimeNumber(p, p - 1);
    }

    private static boolean isPrimeNumber(int p, int z) {
        if (z == 1) return true;
        if (p % z == 0) return false;
        return isPrimeNumber(p, z - 1);
    }
}
