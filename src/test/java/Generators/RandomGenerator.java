package Generators;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomGenerator {

    static String getRandomString(int count) {
        return RandomStringUtils.randomAlphabetic(count);
    }

    static double getRandomNumber(double min, double max) {
        return (Math.random() * (max - min)) + min;
    }

    static float getRandomPrice(double min, double max) {
        return (float)Math.round(getRandomNumber(min, max) * 100f) / 100f;
    }
}
