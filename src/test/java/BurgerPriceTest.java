import Generators.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

/**
 * Тестирование цен бургера.
 */
@RunWith(Parameterized.class)
public class BurgerPriceTest {
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    private final Burger burger;
    private final float bunPrice;
    private final float ingredientPrice;
    private final IngredientType ingredientType;
    private final float expectedPrice;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    public BurgerPriceTest(float bunPrice, float ingredientPrice, IngredientType ingredientType, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.ingredientType = ingredientType;
        this.expectedPrice = expectedPrice;

        this.burger = new Burger();
    }

    @Parameterized.Parameters
    public static Object[][] getBurgersData() {
        return new Object[][]{
                {0, 0, IngredientType.FILLING, 0},
                {100, 0, IngredientType.FILLING, 200},
                {100, 20, IngredientType.FILLING, 220},
                {0, 0, IngredientType.SAUCE, 0},
                {100, 0, IngredientType.SAUCE, 200},
                {100, 20, IngredientType.SAUCE, 220},
        };
    }

    /**
     * Цена бургера должна совпадать с указанной.
     */
    @Test
    public void shouldMakeOrder() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);

        Assert.assertEquals(
                "Цена бургера должна совпадать с указанной.",
                expectedPrice,
                burger.getPrice(),
                Constants.DELTA_PRICE_EQUALITY
        );
    }
}
