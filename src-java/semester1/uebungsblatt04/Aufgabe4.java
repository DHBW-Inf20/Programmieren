package semester1.uebungsblatt04;

import java.util.Scanner;

public class Aufgabe4 {

    public static void main(String[] args) {
        System.out.print("Bitte geben Sie eine Zeichenkette ein: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Umgekehrt: " + new StringBuilder(input).reverse());
    }
}
