package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IngredientTest {
    Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90.12f);
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(90.12f, ingredient.getPrice(), 0);
    }

    @Test
    public void getName() {
        Assert.assertEquals("Соус Spicy-X", ingredient.getName());
    }

    @Test
    public void getType() {
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}