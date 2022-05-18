import Generators.BunGenerator;
import Generators.Constants;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    @Test
    public void ShouldBunHasInitialNameTest(){
        String bunName = BunGenerator.getRandomName();
        Bun bun = new Bun(bunName, 0f);

        Assert.assertEquals("Название созданной булочки должно совпадать с заданным." , bunName, bun.getName());
    }

    @Test
    public void ShouldBunHasInitialPriceTest(){
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
