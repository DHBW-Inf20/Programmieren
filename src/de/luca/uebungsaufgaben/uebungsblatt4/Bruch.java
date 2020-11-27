package de.luca.uebungsaufgaben.uebungsblatt4;

public class Bruch implements Comparable<Bruch> {

    int zaehler;
    int nenner;

    public Bruch() {
        this.zaehler = 1;
        this.nenner = 1;
        this.kuerzen();
    }

    public Bruch(int zaehler, int nenner) {
        this.zaehler = zaehler;
        if (nenner != 0) {
            this.nenner = nenner;
        } else { // Fehlerfall; wie man dies korrekt behandelt folgt spaeter
            this.nenner = 1;
        }
        this.kuerzen();
    }

    private int abs(int zahl) {
        if (zahl >= 0)
            return zahl;
        return -1 * zahl;
    }

    private int ggt(int zahl1, int zahl2) {
        if (zahl1 >= zahl2) {
            if (zahl1 % zahl2 == 0)
                return zahl2;
            else
                return ggt(zahl2, zahl1 - zahl2);
        } else
            return ggt(zahl2, zahl1);
    }

    private void kuerzen() {
        if (this.zaehler == 0) {
            this.nenner = 1;
            return;
        }
        int kuerzFaktor = ggt(abs(this.zaehler), abs(this.nenner));
        this.zaehler /= kuerzFaktor;
        this.nenner /= kuerzFaktor;
        if (this.zaehler < 0) {
            this.zaehler = -this.zaehler;
            this.nenner = -this.nenner;
        }
    }

    @Override
    public int compareTo(Bruch o) {
        double thisAsDouble = (double) this.zaehler / this.nenner;
        double oAsDouble = (double) o.zaehler / o.nenner;
        return Double.compare(thisAsDouble, oAsDouble);
    }
}
