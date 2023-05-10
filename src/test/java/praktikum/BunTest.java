package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest {
    Bun bun;

    @Before
    public void setUp(){
        bun = new Bun("Флюоресцентная булка R2-D3", 988.3f);
    }

    @Test
    public void getName() {
        Assert.assertEquals("Флюоресцентная булка R2-D3",bun.getName());
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(988.3f,bun.getPrice(),0);
    }
}