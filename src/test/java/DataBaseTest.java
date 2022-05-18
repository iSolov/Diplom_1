import org.junit.Assert;
import org.junit.Test;
import praktikum.Database;

public class DataBaseTest {
    @Test
    public void ShouldDatabaseHasBunsTest(){
        Assert.assertTrue(
            "В базе данных должны быть булочки." ,
            new Database().availableBuns().size() > 0
        );
    }

    @Test
    public void ShouldDatabaseHasIngredientsTest(){
        Assert.assertTrue(
            "В базе данных должны быть ингредиенты." ,
            new Database().availableIngredients().size() > 0
        );
    }
}
