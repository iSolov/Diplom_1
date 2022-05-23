import Generators.Constants;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.*;

/**
 * Тестирование цен бургера.
 */
@RunWith(Parameterized.class)
public class BurgerPriceTest {
    private final Burger burger;
    private final float expectedPrice;

    public BurgerPriceTest(Bun bun, Ingredient[] ingredients, float expectedPrice){
        this.burger = new Burger();
        this.burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            this.burger.addIngredient(ingredient);
        }

        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getBurgersData() {
        return new Object[][]{
            {
                new Bun("Bun", 100),
                new Ingredient[]{ },
                200
            },
            {
                new Bun("Bun", 100),
                new Ingredient[]{
                    new Ingredient(IngredientType.SAUCE, "Sauce", 100),
                },
                300
            },
            {
                new Bun("Bun", 100),
                new Ingredient[]{
                    new Ingredient(IngredientType.SAUCE, "Sauce", 100),
                    new Ingredient(IngredientType.FILLING, "Filling 1", 200),
                    new Ingredient(IngredientType.FILLING, "Filling 2", 300),
                },
                800
            },
            {
                new Bun("Bun", 0),
                new Ingredient[]{
                    new Ingredient(IngredientType.SAUCE, "Sauce", 0),
                },
                0
            },
            {
                new Bun("Bun", 200),
                new Ingredient[]{
                    new Ingredient(IngredientType.FILLING, "Filling", 500),
                    new Ingredient(IngredientType.FILLING, "Filling", 500),
                },
                1400
            },
        };
    }

    /**
     * "Цена бургера должна совпадать с указанной."
     */
    @Test
    public void shouldMakeOrder() {
        Assert.assertEquals(
            "Цена бургера должна совпадать с указанной.",
            expectedPrice,
            burger.getPrice(),
            Constants.DELTA_PRICE_EQUALITY
        );
    }
}
