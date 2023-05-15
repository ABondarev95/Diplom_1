package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger stellarBurger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient sauce;

    @Mock
    private Ingredient filling;

    private static final String NAME_BUN = "Флюоресцентная булка R2-D3";
    private static final String NAME_SAUCE = "Соус фирменный Space Sauce";
    private static final String NAME_FILLING = "Мясо бессмертных моллюсков Protostomia";

    @Before
    public void setUp() {
        stellarBurger = new Burger();
    }

    @Test
    public void setBunsTest() {
        stellarBurger.setBuns(bun);
        assertEquals("Неверное значение в поле bun", bun, stellarBurger.bun);
    }

    @Test
    public void addIngredientTest() {
        stellarBurger.addIngredient(sauce);
        stellarBurger.addIngredient(filling);
        assertEquals("Неверное количество ингредиентов", 2, stellarBurger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        stellarBurger.addIngredient(sauce);
        stellarBurger.addIngredient(filling);
        stellarBurger.removeIngredient(1);
        assertEquals("Неверное количество ингредиентов", 1, stellarBurger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        stellarBurger.addIngredient(sauce);
        stellarBurger.addIngredient(filling);
        stellarBurger.moveIngredient(1, 0);
        assertEquals("Неверная позиция ингредиента", filling, stellarBurger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        stellarBurger.setBuns(bun);
        stellarBurger.addIngredient(sauce);
        stellarBurger.addIngredient(filling);
        Mockito.when(bun.getPrice()).thenReturn(988f);
        Mockito.when(sauce.getPrice()).thenReturn(80f);
        Mockito.when(filling.getPrice()).thenReturn(1337f);
        float expectedResult = 988f * 2 + 80f + 1337f;
        assertEquals("Неверная цена бургера", expectedResult, stellarBurger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        stellarBurger.setBuns(bun);
        stellarBurger.addIngredient(sauce);
        stellarBurger.addIngredient(filling);

        Mockito.when(bun.getPrice()).thenReturn(988f);
        Mockito.when(bun.getName()).thenReturn(NAME_BUN);

        Mockito.when(sauce.getName()).thenReturn(NAME_SAUCE);
        Mockito.when(sauce.getType()).thenReturn(SAUCE);
        Mockito.when(sauce.getPrice()).thenReturn(80f);

        Mockito.when(filling.getName()).thenReturn(NAME_FILLING);
        Mockito.when(filling.getType()).thenReturn(FILLING);
        Mockito.when(filling.getPrice()).thenReturn(1337f);

        String expected = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", sauce.getType().toString().toLowerCase(), sauce.getName()) +
                String.format("= %s %s =%n", filling.getType().toString().toLowerCase(), filling.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", stellarBurger.getPrice());

        assertEquals(expected, stellarBurger.getReceipt());
    }

}