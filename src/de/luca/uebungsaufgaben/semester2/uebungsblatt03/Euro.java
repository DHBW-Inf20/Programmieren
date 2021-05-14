package de.luca.uebungsaufgaben.semester2.uebungsblatt03;

import static java.lang.Math.round;

public class Euro {

    private final double amount;

    public Euro(double amount) {
        this.amount = amount;
    }

    public Euro add(Euro other) {
        return new Euro(this.getAmount() + other.getAmount());
    }

    public double getAmount() {
        return round(amount * 100) / 100.0;
    }
}
