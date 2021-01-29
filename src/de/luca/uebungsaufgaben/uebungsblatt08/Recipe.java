package de.luca.uebungsaufgaben.uebungsblatt08;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public final class Recipe {

    private final String name;
    private final List<Ingredient> ingredients;

    public Recipe(String name, Ingredient... ingredients) {
        this.name = name;
        this.ingredients = new LinkedList<>();
        this.ingredients.addAll(Arrays.asList(ingredients));
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(name + ":");
        for (Ingredient ingredient : ingredients) {
            str.append("\n    ").append(ingredient.toString());
        }
        return str.toString();
    }
}
