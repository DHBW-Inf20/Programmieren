package de.luca.uebungsaufgaben.semester1.uebungsblatt08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public final class CookBook {

    private final List<Recipe> recipes;

    public CookBook(Recipe... recipes) {
        this.recipes = new LinkedList<>();
        addRecipesFromDatabase();
        addRecipes(recipes);
    }

    public void addRecipes(Recipe... recipes) {
        this.recipes.addAll(Arrays.asList(recipes));
    }

    private void addRecipesFromDatabase() {
        for (List<String> recipe : Recipes.recipes) {

            String recipeName = recipe.get(0);
            List<String> ingredients = recipe.subList(1, recipe.size());
            List<Ingredient> ingredientList = new ArrayList<>(ingredients.size());

            for (String ingredient : ingredients) {
                ingredientList.add(new Ingredient(ingredient));
            }

            addRecipes(new Recipe(recipeName, ingredientList.toArray(new Ingredient[0])));
        }
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
}
