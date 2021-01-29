package de.luca.uebungsaufgaben.uebungsblatt08;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public final class Stock {

    private final List<Ingredient> ingredients;

    public Stock(Ingredient... ingredients) {
        this.ingredients = new LinkedList<>();
        addIngredients(ingredients);
    }

    public void addIngredients(Ingredient... ingredients) {
        this.ingredients.addAll(Arrays.asList(ingredients));
    }

    public void removeIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }

    public boolean contains(Ingredient ingredient) {
        return ingredients.contains(ingredient);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("In stock:");
        for (Ingredient ingredient : ingredients) {
            str.append("\n    ").append(ingredient.toString());
        }
        return str.toString();
    }
}
