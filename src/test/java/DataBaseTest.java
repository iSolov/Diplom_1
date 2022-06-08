import org.junit.Assert;
import org.junit.Test;
import praktikum.Database;

/**
 * Тест базы данных.
 */
public class DataBaseTest {
    /**
     * В базе данных должны быть булочки.
     */
    @Test
    public void shouldDatabaseHasBunsTest(){
        Assert.assertTrue(
            "В базе данных должны быть булочки." ,
            new Database().availableBuns().size() > 0
        );
    }

    /**
     * В базе данных должны быть ингредиенты.
     */
    @Test
    public void shouldDatabaseHasIngredientsTest(){
        Assert.assertTrue(
            "В базе данных должны быть ингредиенты." ,
            new Database().availableIngredients().size() > 0
        );
    }
}
