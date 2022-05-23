package Generators;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Генератор случайных величин.
 */
public class RandomGenerator {

    /**
     * Получает случайную строку.
     */
    static String getRandomString(int count) {
        return RandomStringUtils.randomAlphabetic(count);
    }

    /**
     * Получает случайное число.
     */
    static double getRandomNumber(double min, double max) {
        return (Math.random() * (max - min)) + min;
    }

    /**
     * Получает случайную цену.
     */
    static float getRandomPrice(double min, double max) {
        return (float)Math.round(getRandomNumber(min, max) * 100f) / 100f;
    }
}
