import Generators.Constants;
import Generators.IngredientGenerator;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    @Test
    public void ShouldIngredientHasInitialTypeTest(){
        IngredientType ingredientType = IngredientGenerator.gerRandomType();
        Ingredient ingredient = new Ingredient(ingredientType, "Ingredient", 0f);

        Assert.assertEquals("Тип созданного ингредиента должен совпадать с заданным." , ingredientType, ingredient.getType());
    }

    @Test
    public void ShouldIngredientHasInitialNameTest(){
        String ingredientName = IngredientGenerator.getRandomName();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, ingredientName, 0f);

        Assert.assertEquals("Название созданного ингредиента должно совпадать с заданным." , ingredientName, ingredient.getName());
    }

    @Test
    public void ShouldIngredientHasInitialPriceTest(){
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
