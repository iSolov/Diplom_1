package Generators;

import praktikum.Bun;

/**
 * Генератор случайных булочек.
 */
public class BunGenerator {
    /**
     * Получайет случайную булочку.
     */
    public static Bun getRandomBun(){
        return new Bun(getRandomName(), getRandomPrice());
    }

    /**
     * Получайет случайное имя.
     */
    public static String getRandomName(){
        int randomNameLength = (int)RandomGenerator.getRandomNumber(Constants.MIN_BUN_NAME_LENGTH, Constants.MAX_BUN_NAME_LENGTH);
        return RandomGenerator.getRandomString(randomNameLength);
    }

    /**
     * Получает случайную цену.
     */
    public static float getRandomPrice(){
        return RandomGenerator.getRandomPrice(Constants.MIN_BUN_PRICE, Constants.MAX_BUN_PRICE);
    }
}
