package Generators;

import java.util.Random;
import praktikum.Ingredient;
import praktikum.IngredientType;

/**
 * Генератор случайных ингредиентов.
 */
public class IngredientGenerator {
    /**
     * Получает случайный ингредиент.
     */
    public static Ingredient getRandomIngredient(){
        return new Ingredient(gerRandomType(), getRandomName(), getRandomPrice());
    }

    /**
     * Получает случайное имя ингредиента.
     */
    public static String getRandomName(){
        int randomNameLength = (int)RandomGenerator.getRandomNumber(Constants.MIN_INGREDIENT_NAME_LENGTH, Constants.MAX_INGREDIENT_NAME_LENGTH);
        return RandomGenerator.getRandomString(randomNameLength);
    }

    /**
     * Получает случайную цену ингредиента.
     */
    public static float getRandomPrice(){
        return RandomGenerator.getRandomPrice(Constants.MIN_INGREDIENT_PRICE, Constants.MAX_INGREDIENT_PRICE);
    }

    /**
     * Получает случайный тип.
     */
    public static IngredientType gerRandomType(){
        return new Random().nextBoolean() ? IngredientType.SAUCE : IngredientType.FILLING;
    }
}
