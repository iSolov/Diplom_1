import Generators.Constants;
import Generators.IngredientGenerator;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

/**
 * Тип созданного ингредиента должен совпадать с заданным.
 */
public class IngredientTest {
    @Test
    public void shouldIngredientHasInitialTypeTest(){
        IngredientType ingredientType = IngredientGenerator.gerRandomType();
        Ingredient ingredient = new Ingredient(ingredientType, "Ingredient", 0f);

        Assert.assertEquals("Тип созданного ингредиента должен совпадать с заданным." , ingredientType, ingredient.getType());
    }

    /**
     * Название созданного ингредиента должно совпадать с заданным.
     */
    @Test
    public void shouldIngredientHasInitialNameTest(){
        String ingredientName = IngredientGenerator.getRandomName();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, ingredientName, 0f);

        Assert.assertEquals("Название созданного ингредиента должно совпадать с заданным." , ingredientName, ingredient.getName());
    }

    /**
     * Цена созданного ингредиента должна совпадать с заданным.
     */
    @Test
    public void shouldIngredientHasInitialPriceTest(){
        float price = IngredientGenerator.getRandomPrice();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Ingredient", price);

        Assert.assertEquals(
            "Цена созданного ингредиента должна совпадать с заданным." ,
            price,
            ingredient.getPrice(),
            Constants.DELTA_PRICE_EQUALITY
        );
    }
}
