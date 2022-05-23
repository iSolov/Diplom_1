import Generators.BunGenerator;
import Generators.BurgerGenerator;
import Generators.Constants;
import Generators.IngredientGenerator;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

/**
 * Тест бургера.
 */
public class BurgerTest {
    /**
     * Цена бургера только с булочками должна быть равна двойной цене булочки.
     */
    @Test
    public void shouldBurgerHasDoublePriceWithOnlyBuns(){
        Burger burger = new Burger();

        Bun bun = BunGenerator.getRandomBun();
        burger.setBuns(bun);

        Assert.assertEquals(
            "Цена бургера только с булочками должна быть равна двойной цене булочки.",
            bun.getPrice() * 2,
            burger.getPrice(),
            Constants.DELTA_PRICE_EQUALITY
        );
    }

    /**
     * Бургер должен содержать ингредиенты, если их в него добавить.
     */
    @Test
    public void shouldBurgerHasIngredientsAfterAddingTest(){
        Burger burger = new Burger();

        burger.setBuns(BunGenerator.getRandomBun());

        int ingredientsCount = 5;
        for (int i = 0; i < ingredientsCount; i++) {
            burger.addIngredient(IngredientGenerator.getRandomIngredient());
        }

        Assert.assertEquals(
            "После добавления " + ingredientsCount + " ингредиентов, общее их количество должно быть 3 в бургере.",
            ingredientsCount,
            burger.ingredients.size()
        );
    }

    /**
     * Бургер должен содержать ингредиенты, если их в него добавить и удалить несколько.
     */
    @Test
    public void shouldBurgerHasIngredientsAfterAddingAndRemovingTest(){
        Burger burger = BurgerGenerator.getRandomEmptyBurger();

        int ingredientsForAddingCount = 5;
        for (int i = 0; i < ingredientsForAddingCount; i++) {
            burger.addIngredient(IngredientGenerator.getRandomIngredient());
        }

        int ingredientsForRemovingCount = 3;
        for (int i = 0; i < ingredientsForRemovingCount; i++) {
            burger.removeIngredient(i);
        }

        int expectedIngredientsCount = ingredientsForAddingCount - ingredientsForRemovingCount;

        Assert.assertEquals(
            "После добавления " + ingredientsForAddingCount + " ингредиентов и удаления " + ingredientsForRemovingCount +
                ", общее их количество должно быть " + expectedIngredientsCount + " в бургере.",
            expectedIngredientsCount,
            burger.ingredients.size()
        );
    }

    /**
     * Функция изменения положения ингредиента должна отрабатывать корректно.
     */
    @Test
    public void shouldBurgerIngredientsMoveTest(){
        Burger burger = BurgerGenerator.getRandomEmptyBurger();

        int oldIndex = 0;
        int newIndex = 1;

        Ingredient firstIngredient = IngredientGenerator.getRandomIngredient();
        Ingredient secondIngredient = IngredientGenerator.getRandomIngredient();

        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        burger.moveIngredient(oldIndex, newIndex);

        Assert.assertTrue(
            "После изменения положения ингредиента он =должен поменять позицию.",
            firstIngredient == burger.ingredients.get(newIndex) && secondIngredient == burger.ingredients.get(oldIndex)
        );
    }

    /**
     * Цена бургера должна быть больше нуля у случайного бургера.
     */
    @Test
    public void shouldNotEmptyBurgerHasPriceTest(){
        Burger burger = BurgerGenerator.getRandomBurger();

        Assert.assertTrue(
            "Цена бургера должна быть больше нуля.",
            burger.getPrice() > 0.0f
        );
    }

    /**
     * Рецепт бургера должен быть не пустым у случайного бургера.
     */
    @Test
    public void shouldBurgerPrintReceiptTest(){
        Assert.assertFalse(
            "Рецепт бургера должен быть не пустым.",
            BurgerGenerator
                .getRandomBurger()
                .getReceipt()
                .isEmpty()
        );
    }
}
