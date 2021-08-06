package semester2.uebungsblatt03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Aufgabe3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Eingabe einer Zahl: ");
        try {
            final int input = scanner.nextInt();
            if (input % 2 == 0) System.out.println("Zahl ist gerade");
            else System.out.println("Zahl ist ungerade");
        } catch (InputMismatchException e) {
            System.out.println("Eingabe wahr wohl falsch");
        }
    }
}
