package semester1.uebungsblatt08;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public final class KitchenHelper {

    private final CookBook cookBook;
    private final Stock stock;

    public KitchenHelper() {
        cookBook = new CookBook();
        stock = new Stock();
    }

    public void addIngredientsToStock(String... ingredients) {
        for (String ingredient : ingredients) {
            stock.addIngredients(new Ingredient(ingredient));
        }
    }

    public void removeIngredientsFromStock(String... ingredients) {
        for (String ingredient : ingredients) {
            stock.removeIngredient(new Ingredient(ingredient));
        }
    }

    public void addRecipe(String name, String... ingredientNames) {
        Ingredient[] ingredients = Arrays.stream(ingredientNames)
                .map(Ingredient::new)
                .toArray(Ingredient[]::new);
        Recipe recipe = new Recipe(name, ingredients);
        cookBook.addRecipes(recipe);
    }

    public String getRecipesFromStock() {
        List<Recipe> result = new LinkedList<>();

        for (Recipe recipe : cookBook.getRecipes()) {
            boolean hasAllIngredients = true;

            for (Ingredient ingredient : recipe.getIngredients()) {
                if (!stock.contains(ingredient)) {
                    hasAllIngredients = false;
                    break;
                }
            }

            if (hasAllIngredients) result.add(recipe);
        }

        StringBuilder str = new StringBuilder("Possible recipes:");

        for (Recipe recipe : result) {
            str.append("\n\n").append(recipe.toString());
        }

        return str.toString();
    }

    public String stockToString() {
        return stock.toString();
    }
}
