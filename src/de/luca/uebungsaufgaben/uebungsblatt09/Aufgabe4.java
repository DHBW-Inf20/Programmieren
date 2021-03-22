package de.luca.uebungsaufgaben.uebungsblatt09;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Aufgabe4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inputWithOneCorrection(scanner);
        inputWithAsManyCorrectionsAsNecessary(scanner);
        inputWithAsManyCorrectionsAsNecessaryWithoutException(scanner);
    }

    private static void inputWithOneCorrection(Scanner scanner) {
        System.out.println("Input with one correction:");
        int result;
        try {
            System.out.print("Input integer: ");
            result = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.print("This was no integer, try again: ");
            scanner.next();
            result = scanner.nextInt();
        }
        System.out.println("Your input: " + result + "\n");
    }

    private static void inputWithAsManyCorrectionsAsNecessary(Scanner scanner) {
        System.out.print("Input with as many corrections as necessary:\nInput integer: ");
        while (true) {
            try {
                int result = scanner.nextInt();
                System.out.println("Your input: " + result + "\n");
                break;
            } catch (InputMismatchException e) {
                System.out.print("This was no integer, try again: ");
                scanner.next();
            }
        }
    }

    private static void inputWithAsManyCorrectionsAsNecessaryWithoutException(Scanner scanner) {
        System.out.print("Input with as many corrections as necessary without exceptions:\nInput integer: ");
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.print("This was no integer, try again: ");
                scanner.next();
                continue;
            }
            int result = scanner.nextInt();
            System.out.println("Your input: " + result + "\n");
            break;
        }
    }
}
