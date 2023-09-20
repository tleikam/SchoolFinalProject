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
import evenbetterpurchase.data.appliances.Oven;
import evenbetterpurchase.data.enums.Color;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Test Class for Oven.
 *
 *<p>This class ensures the Oven class functions correctly
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class OvenTest {

    @Test
    public void testOvenIsAnAppliance() {
        Oven oven = new Oven();
        assertTrue(oven instanceof Appliance);
    }

    @Test
    public void testOvenIsAnItem() {
        Oven oven = new Oven();
        assertTrue(oven instanceof Item);
    }

    @Test
    public void testConstructorSetsCorrectValues() {
        Oven oven = new Oven();
        assertTrue(oven.getElectricStoveTop());
        assertTrue(oven.getElectricOven());
        assertThat(oven.getColor(), is(Color.STAINLESS_STEEL));
    }

    @Test
    public void testOvenHasCorrectPrice() {
        Oven oven = new Oven();
        



    }

    @Test
    public void testOvenDiscountsCorrectly() {
        Oven oven = new Oven();
        double temp = Double.parseDouble(String.format(".2f",
                            (oven.getPrice() - (oven.getPrice() * .75))));
        oven.setPrice("75 percent");
        assertThat(oven.getPrice(), is(temp));
    }

    @Test
    public void testOvenDoesntDiscountWithWrongString() {
        Oven oven = new Oven();
        double temp = oven.getPrice();
        oven.setPrice("FREE");
        assertThat(oven.getPrice(), is(temp));
    }

    @Test
    public void testOvenGetAndSetColorWorks() {
        Oven oven = new Oven();
        assertThat(oven.getColor(), is(Color.STAINLESS_STEEL));
        oven.setColor(Color.BLACK);
        assertThat(oven.getColor(), is(Color.BLACK));
        oven.setColor(Color.WHITE);
        assertThat(oven.getColor(), is(Color.WHITE));
        oven.setColor(Color.BLUE);
        assertThat(oven.getColor(), is(Color.BLUE));
    }

    @Test
    public void testOvenGetNameReturnsCorrectly() {
        Oven oven = new Oven();
        assertThat(oven.getName(), is("Oven"));
    }

    @Test
    public void testOvenGetterAndSetterElectricStoveTopWorks() {
        Oven oven = new Oven();
        assertTrue(oven.getElectricStoveTop());
        oven.setElectricStoveTop(false);
        assertFalse(oven.getElectricStoveTop());
    }

    @Test
    public void testOvenGetterAndSetterElectricOvenWorks() {
        Oven oven = new Oven();
        assertTrue(oven.getElectricOven());
        oven.setElectricOven(false);
        assertFalse(oven.getElectricOven());
    }

    @Test
    public void testOvenToStringWorksCorrectly() {
        Oven oven = new Oven();
        assertThat(oven.toString(), is(oven.getColor()
                + " Electric Oven with Electric Stove Top"));
        oven.setElectricOven(false);
        assertThat(oven.toString(), is(oven.getColor()
                + " Gas Oven with Electric Stove Top"));
        oven.setElectricStoveTop(false);
        assertThat(oven.toString(), is(oven.getColor()
                + " Gas Oven with Gas Stove Top"));
        oven.setElectricOven(true);
        assertThat(oven.toString(), is(oven.getColor()
                + " Electric Oven with Gas Stove Top"));
    }

    @Test
    public void testOvenGetName() {
        Oven oven = new Oven();
        assertThat(oven.getName(), is("Oven"));
    }

    @Test
    public void testOvenEqualsMethod() {
        Oven oven = new Oven();
        Oven other = new Oven();
        assertTrue(oven.equals(other));
        other.setElectricStoveTop(false);
        assertFalse(oven.equals(other));
        DishWasher notOven = new DishWasher();
        assertFalse(oven.equals(notOven));
    }

    @Test
    public void testOvenDescriptors() {
        Oven oven = new Oven();
        LinkedList<String> d = oven.descriptors();
        assertTrue(d.contains(oven.getColor() + ""));
        assertTrue(d.contains("Electric Oven"));
        assertTrue(d.contains("Electric Stove Top"));
        assertFalse(d.contains("Gas Oven"));
        assertFalse(d.contains("Gas Stove Top"));
        oven.setElectricOven(false);
        oven.setElectricStoveTop(false);
        d = oven.descriptors();
        assertTrue(d.contains("Gas Oven"));
        assertTrue(d.contains("Gas Stove Top"));
        assertFalse(d.contains("Electric Oven"));
        assertFalse(d.contains("Electric Stove Top"));
    }

    @Test
    public void testOvenOptions() {
        Oven oven = new Oven();
        LinkedList<String> d = oven.options();
        assertTrue(d.contains("Electric or Gas Oven"));
        assertTrue(d.contains("Electric or Gas Stove Top"));
    }
}