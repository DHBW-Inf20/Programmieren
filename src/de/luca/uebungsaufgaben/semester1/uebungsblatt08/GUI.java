package de.luca.uebungsaufgaben.semester1.uebungsblatt08;

import java.util.Arrays;
import java.util.Scanner;

public class GUI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KitchenHelper helper = new KitchenHelper();

        chooseNext(scanner, helper);
    }

    public static void chooseNext(Scanner scanner, KitchenHelper helper) {
        System.out.println("""
                ------------------------------------
                | 0 - Print stock                  |
                | 1 - Add ingredient to stock      |
                | 2 - Remove ingredient from stock |
                | 3 - Add recipe                   |
                | 4 - Print possible recipes       |
                | 5 - Exit                         |
                ------------------------------------
                """);
        System.out.print("Choose: ");

        boolean validInput = false;
        int chosen = 0;

        do {
            String chosenString = scanner.nextLine();
            try {
                chosen = Integer.parseInt(chosenString);
                if (chosen < 0 || chosen > 5) {
                    System.out.print("Enter valid input: ");
                } else validInput = true;
            } catch (NumberFormatException e) {
                System.out.print("Enter valid input: ");
            }
        } while (!validInput);

        System.out.println();

        switch (chosen) {
            case 0 -> printStock(scanner, helper);
            case 1 -> addIngredientToStock(scanner, helper);
            case 2 -> removeIngredientFromStock(scanner, helper);
            case 3 -> addRecipe(scanner, helper);
            case 4 -> printPossibleRecipes(scanner, helper);
            case 5 -> System.out.println("Exited.");
        }
    }

    public static void printStock(Scanner scanner, KitchenHelper helper) {
        System.out.println(helper.stockToString());
        pressEnterToContinue(scanner, helper);
    }

    public static void addIngredientToStock(Scanner scanner, KitchenHelper helper) {
        System.out.print("Enter name of ingredient: ");
        helper.addIngredientsToStock(scanner.nextLine());
        System.out.println();
        chooseNext(scanner, helper);
    }

    public static void removeIngredientFromStock(Scanner scanner, KitchenHelper helper) {
        System.out.print("Enter name of ingredient: ");
        helper.removeIngredientsFromStock(scanner.nextLine());
        System.out.println();
        chooseNext(scanner, helper);
    }

    public static void addRecipe(Scanner scanner, KitchenHelper helper) {
        System.out.print("Enter name of recipe: ");
        String name = scanner.nextLine();
        System.out.print("Enter ingredients (comma-separated): ");
        String ingredientsString = scanner.nextLine();
        String[] ingredients = Arrays.stream(ingredientsString.split(","))
                .map(String::strip)
                .filter(str -> !str.isEmpty())
                .toArray(String[]::new);
        helper.addRecipe(name, ingredients);
        System.out.println();
        chooseNext(scanner, helper);
    }

    public static void printPossibleRecipes(Scanner scanner, KitchenHelper helper) {
        System.out.println(helper.getRecipesFromStock());
        pressEnterToContinue(scanner, helper);
    }

    private static void pressEnterToContinue(Scanner scanner, KitchenHelper helper) {
        System.out.print("\nPress enter to continue.");
        scanner.nextLine();
        System.out.println();
        chooseNext(scanner, helper);
    }
}
