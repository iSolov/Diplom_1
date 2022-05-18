package Generators;

import praktikum.Bun;

public class BunGenerator {
    public static Bun getRandomBun(){
        return new Bun(getRandomName(), getRandomPrice());
    }

    public static String getRandomName(){
        int randomNameLength = (int)RandomGenerator.getRandomNumber(Constants.MIN_BUN_NAME_LENGTH, Constants.MAX_BUN_NAME_LENGTH);
        return RandomGenerator.getRandomString(randomNameLength);
    }

    public static float getRandomPrice(){
        return RandomGenerator.getRandomPrice(Constants.MIN_BUN_PRICE, Constants.MAX_BUN_PRICE);
    }
}
