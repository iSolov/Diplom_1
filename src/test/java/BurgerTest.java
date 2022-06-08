import Generators.BunGenerator;
import Generators.Constants;
import Generators.IngredientGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

/**
 * Тест бургера.
 */
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    Burger burger = new Burger();

    /**
     * Цена бургера только с булочками должна быть равна двойной цене булочки.
     */
    @Test
    public void shouldBurgerHasDoublePriceWithOnlyBuns() {
        float bunPrice = BunGenerator.getRandomPrice();
        float expectedPrice = bunPrice * 2;

        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);

        Assert.assertEquals(
                "Цена бургера только с булочками должна быть равна двойной цене булочки.",
                expectedPrice,
                burger.getPrice(),
                Constants.DELTA_PRICE_EQUALITY
        );
    }

    /**
     * Бургер должен содержать ингредиенты, если их в него добавить.
     */
    @Test
    public void shouldBurgerHasIngredientAfterAddingTest() {
        burger.addIngredient(ingredient);

        int ingredientsCountExpected = 1;

        Assert.assertEquals(
                "После добавления ингредиента, общее их количество должно быть 3 в бургере.",
                ingredientsCountExpected,
                burger.ingredients.size()
        );
    }

    /**
     * Бургер должен содержать ингредиенты, если их в него добавить и удалить несколько.
     */
    @Test
    public void shouldBurgerHasIngredientsAfterAddingAndRemovingTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        List<Ingredient> expected = new ArrayList<>();

        Assert.assertEquals(
                "После добавления ингредиента и удаления, общее их количество должно быть 0 в бургере.",
                expected,
                burger.ingredients
        );
    }

    /**
     * Функция изменения положения ингредиента должна отрабатывать корректно.
     */
    @Test
    public void shouldBurgerIngredientsMoveTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);

        Assert.assertNotNull(
                "После изменения положения ингредиента он должен поменять позицию.",
                burger.ingredients.get(1)
        );
    }

    /**
     * Цена бургера должна быть больше нуля у случайного бургера.
     */
    @Test
    public void shouldNotEmptyBurgerHasPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(BunGenerator.getRandomPrice());
        Mockito.when(ingredient.getPrice()).thenReturn(IngredientGenerator.getRandomPrice());

        Assert.assertTrue(
                "Цена случайного бургера должна быть больше нуля.",
                burger.getPrice() > 0.0f
        );
    }

    /**
     * Рецепт бургера должен быть не пустым.
     */
    @Test
    public void shouldBurgerPrintReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(bun.getName()).thenReturn("BunName");

        Mockito.when(ingredient.getName()).thenReturn("IngredientName");
        Mockito.when((ingredient.getType())).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getPrice()).thenReturn(200f);

        Assert.assertFalse(
                "Рецепт бургера должен быть не пустым.",
                burger.getReceipt().isEmpty()
        );
    }
}
