package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {
    Bun bun;
    private String bunName;
    private float price;

    public BunTest(String bunName, float price){
        this.bunName = bunName;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] bunTest() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 988f},
                {"", -1f},
                {null, 0f},
                {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 0.01f},
                {"!“№ ;%: ?*()_+/, § $&= @#«» <>~®-;²³", 99999999999999999999999f},
                {"1337", -0f},
        };
    }

    @Test
    public void getName() {
        bun = new Bun(bunName,988f);
        Assert.assertEquals(bunName, bun.getName());
    }

    @Test
    public void getPrice() {
        bun = new Bun("Флюоресцентная булка R2-D3",price);
        Assert.assertEquals(price, bun.getPrice(),0);
    }
}