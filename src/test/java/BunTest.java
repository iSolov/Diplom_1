import Generators.BunGenerator;
import Generators.Constants;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

/**
 * Тест булочки.
 */
public class BunTest {
    /**
     * Название созданной булочки должно совпадать с заданным.
     */
    @Test
    public void shouldBunHasInitialNameTest(){
        String bunName = BunGenerator.getRandomName();
        Bun bun = new Bun(bunName, 0f);

        Assert.assertEquals(
            "Название созданной булочки должно совпадать с заданным.",
            bunName,
            bun.getName()
        );
    }

    /**
     * Цена созданной булочки должна совпадать с заданным.
     */
    @Test
    public void shouldBunHasInitialPriceTest(){
        float price = BunGenerator.getRandomPrice();
        Bun bun = new Bun("Bun Name", price);

        Assert.assertEquals(
            "Цена созданной булочки должна совпадать с заданным." ,
            price,
            bun.getPrice(),
            Constants.DELTA_PRICE_EQUALITY
        );
    }
}
