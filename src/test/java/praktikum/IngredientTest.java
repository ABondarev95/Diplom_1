package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest{

    private Ingredient ingredient;
    private final IngredientType typeIngredient;
    private final String nameIngredient;
    private final float priceIngredient;

    public IngredientTest(IngredientType typeIngredient, String nameIngredient, float priceIngredient) {
        this.typeIngredient = typeIngredient;
        this.nameIngredient = nameIngredient;
        this.priceIngredient = priceIngredient;
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(typeIngredient, nameIngredient, priceIngredient);
    }

    @Parameterized.Parameters
    public static Object[][] ingredientData() {
        return new Object[][]{
                {SAUCE, "Соус Spicy-X", 90},
                {SAUCE, "Соус фирменный Space Sauce", 80},
                {FILLING, "Мясо бессмертных моллюсков Protostomia", 1337},
                {FILLING, "Плоды Фалленианского дерева", 874},
                {FILLING, "Мини-салат Экзо-Плантаго", 4400},
        };
    }

    @Test
    public void getNameTest() {
        assertEquals("Неверное значение в поле name", ingredient.getName(), nameIngredient);
    }

    @Test
    public void getTypeTest() {
        assertEquals("Неверное значение в поле type", ingredient.getType(), typeIngredient);
    }

    @Test
    public void getPriceTest() {
        assertEquals("Неверное значение в поле price", ingredient.getPrice(), priceIngredient, 0);
    }

}