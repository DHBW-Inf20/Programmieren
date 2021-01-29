package de.luca.uebungsaufgaben.uebungsblatt08;

public final class Ingredient {

    private final String name;

    public Ingredient(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Ingredient)) return false;
        return ((Ingredient) obj).name.equals(this.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
