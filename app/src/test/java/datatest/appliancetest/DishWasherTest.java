package datatest.appliancetest;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import evenbetterpurchase.data.Item;
import evenbetterpurchase.data.appliances.Appliance;
import evenbetterpurchase.data.appliances.DishWasher;
import evenbetterpurchase.data.appliances.Dryer;
import evenbetterpurchase.data.enums.Color;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Test class for DishWasher.
 *
 *<p>This class uses tests to ensure DishWasher is
 functioning as intended.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class DishWasherTest {

    @Test
    public void testDishWasherIsAnAppliance() {
        DishWasher dw = new DishWasher();
        assertTrue(dw instanceof Appliance);
    }

    @Test
    public void testDishWasherIsAnItem() {
        DishWasher dw = new DishWasher();
        assertTrue(dw instanceof Item);
    }

    @Test
    public void testDishWasherHasThirdRack() {
        DishWasher dw = new DishWasher();
        assertTrue(dw.getThirdRack());
    }

    @Test
    public void testDishWasherSetThirdRackWorksCorrectly() {
        DishWasher dw = new DishWasher();
        dw.setThirdRack(false);
        assertFalse(dw.getThirdRack());
        dw.setThirdRack(true);
        assertTrue(dw.getThirdRack());
    }

    @Test
    public void testDishWasherHasCorrectPrice() {
        DishWasher dw = new DishWasher();
        assertEquals(699.99, dw.getPrice());
        dw.setThirdRack(false);
        assertEquals(499.99, dw.getPrice());
    }

    @Test
    public void testDishWasherDiscountsCorrectly() {
        DishWasher dw = new DishWasher();
        double temp = Double.parseDouble(String.format(".2f",
                            (dw.getPrice() - (dw.getPrice() * .75))));
        dw.setPrice("75 percent");
        assertThat(dw.getPrice(), is(temp));
    }

    @Test
    public void testDishWasherDoesntDiscountWithWrongString() {
        DishWasher dw = new DishWasher();
        double temp = dw.getPrice();
        dw.setPrice("FREE");
        assertThat(dw.getPrice(), is(temp));
    }

    @Test
    public void testDishWasherGetAndSetColorWorks() {
        DishWasher dw = new DishWasher();
        assertThat(dw.getColor(), is(Color.STAINLESS_STEEL));
        dw.setColor(Color.BLACK);
        assertThat(dw.getColor(), is(Color.BLACK));
        dw.setColor(Color.WHITE);
        assertThat(dw.getColor(), is(Color.WHITE));
        dw.setColor(Color.BLUE);
        assertThat(dw.getColor(), is(Color.BLUE));
    }

    @Test
    public void testDishWasherGetNameReturnsCorrectly() {
        DishWasher dw = new DishWasher();
        assertThat(dw.getName(), is("Dish Washer"));
    }

    @Test
    public void testDishWasherToStringReturnsCorrectly() {
        DishWasher dw = new DishWasher();
        assertThat(dw.toString(), is("Stainless Steel Dish Washer with Third Rack"));
        dw.setColor(Color.BLACK);
        assertThat(dw.toString(), is("Black Dish Washer with Third Rack"));
        dw.setThirdRack(false);
        assertThat(dw.toString(), is("Black Dish Washer"));
    }

    @Test
    public void testEqualsMethodWorksCorrectly() {
        DishWasher dw = new DishWasher();
        DishWasher other = new DishWasher();
        assertTrue(dw.equals(other));
        other.setColor(Color.WHITE);
        assertFalse(dw.equals(other));
        other.setColor(Color.STAINLESS_STEEL);
        assertTrue(dw.equals(other));
        other.setThirdRack(false);
        assertFalse(dw.equals(other)); 
        Dryer notWasher = new Dryer();
        assertFalse(dw.equals(notWasher));
    }

    @Test
    public void testDescriptors() {
        DishWasher dw = new DishWasher();
        LinkedList<String> d = dw.descriptors();
        assertTrue(d.contains(dw.getColor() + ""));
        assertTrue(d.contains("With third rack"));
        dw.setThirdRack(false);
        d = dw.descriptors();
        assertFalse(d.contains("With third rack"));
    }

    @Test
    public void testDishWasherOptions() {
        DishWasher dw = new DishWasher();
        LinkedList<String> d = dw.options();
        assertTrue(d.contains("Available with Third Rack"));
    }
}