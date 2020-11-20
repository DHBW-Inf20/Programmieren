package de.luca.uebungsaufgaben.uebungsblatt2;

public class Aufgabe1 {

    public static void main(String[] args) {
        int ergebnis = 1;
        int anzahl = 5;

        do{
            ergebnis = ergebnis * 2;
            if(ergebnis > 10) {
                ergebnis = ergebnis - anzahl;
                anzahl--;
            }
        } while (anzahl > 0);   //Hier war ein Syntaxfehler in der Aufgabenstellung (fehlendes ;)

        System.out.println("Das Ergebnis ist " + ergebnis);
    }
}
