package Generators;

import praktikum.Burger;

/**
 * Генератор случайных бургеров.
 */
public class BurgerGenerator {
    /**
     * Получает случайный пустой бургер.
     */
    public static Burger getRandomEmptyBurger(){
        Burger burger = new Burger();
        burger.setBuns(BunGenerator.getRandomBun());
        return burger;
    }

    /**
     * Получает случайный бургер.
     */
    public static Burger getRandomBurger(){
        Burger burger = getRandomEmptyBurger();

        int ingredientsForAddingCount = (int)RandomGenerator.getRandomNumber(Constants.MIN_INGREDIENTS_COUNT, Constants.MAX_INGREDIENTS_COUNT);
        for (int i = 0; i < ingredientsForAddingCount; i++) {
            burger.addIngredient(IngredientGenerator.getRandomIngredient());
        }

        return burger;
    }
}
