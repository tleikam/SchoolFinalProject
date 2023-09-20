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
import evenbetterpurchase.data.enums.DryerSize;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Test Class for Dryer.
 *
 *<p>This class uses tests to ensure Dryer is functioning as intended.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class DryerTest {

    @Test
    public void testDryerIsAnAppliance() {
        Dryer d = new Dryer();
        assertTrue(d instanceof Appliance);
    }

    @Test
    public void testDryerIsAnItem() {
        Dryer d = new Dryer();
        assertTrue(d instanceof Item);
    }

    @Test
    public void testConstructorSetsCorrectValues() {
        Dryer d = new Dryer();
        assertTrue(d.getTopLoadDryer());
        assertFalse(d.getSteamer());
        assertThat(d.getSize(), is(DryerSize.SEVENPOINTTHREE));
        assertThat(d.getColor(), is(Color.WHITE));
    }



    @Test
    public void testDryerHasCorrectPrice() {
        Dryer d = new Dryer();
        



    }

    @Test
    public void testDryerDiscountsCorrectly() {
        Dryer d = new Dryer();
        double temp = Double.parseDouble(String.format(".2f",
                            (d.getPrice() - (d.getPrice() * .75))));
        d.setPrice("75 percent");
        assertThat(d.getPrice(), is(temp));
    }

    @Test
    public void testDryerDoesntDiscountWithWrongString() {
        Dryer d = new Dryer();
        double temp = d.getPrice();
        d.setPrice("FREE");
        assertThat(d.getPrice(), is(temp));
    }

    @Test
    public void testDryerGetAndSetColorWorks() {
        Dryer d = new Dryer();
        assertThat(d.getColor(), is(Color.WHITE));
        d.setColor(Color.BLACK);
        assertThat(d.getColor(), is(Color.BLACK));
        d.setColor(Color.STAINLESS_STEEL);
        assertThat(d.getColor(), is(Color.STAINLESS_STEEL));
        d.setColor(Color.BLUE);
        assertThat(d.getColor(), is(Color.BLUE));
    }

    @Test
    public void testTopLoadDryerSetterAndGetterWorkCorrectly() {
        Dryer d = new Dryer();
        assertTrue(d.getTopLoadDryer());
        d.setTopLoadDryer(false);
        assertFalse(d.getTopLoadDryer());
    }

    @Test
    public void testSteamerDryerSetterAndGetterWorksCorrectly() {
        Dryer d = new Dryer();
        assertFalse(d.getSteamer());
        d.setSteamer(true);
        assertTrue(d.getSteamer());
    }

    @Test
    public void testDryerSizeSetsAndGetsCorrectly() {
        Dryer d = new Dryer();
        assertThat(d.getSize(), is(DryerSize.SEVENPOINTTHREE));
        d.setSize(DryerSize.SIXPOINTSEVEN);
        assertThat(d.getSize(), is(DryerSize.SIXPOINTSEVEN));
        d.setSize(DryerSize.SEVENPOINTEIGHT);
        assertThat(d.getSize(), is(DryerSize.SEVENPOINTEIGHT));
        d.setSize(DryerSize.NINEPOINTZERO);
        assertThat(d.getSize(), is(DryerSize.NINEPOINTZERO));
    }

    @Test
    public void testToStringForDryer() {
        Dryer d = new Dryer();
        assertThat(d.toString(), is(d.getSize() + " cu. ft. " + d.getColor() + " Dryer"));
    }    

    @Test
    public void testDryerGetName() {
        Dryer d = new Dryer();
        assertThat(d.getName(), is("Dryer"));
    }

    @Test
    public void testDryerEqualsMethodWorksCorrectly() {
        Dryer d = new Dryer();
        Dryer other = new Dryer();
        DishWasher notDryer = new DishWasher();
        assertTrue(d.equals(other));
        assertFalse(d.equals(notDryer));
        other.setSteamer(true);
        assertFalse(d.equals(other));
    }

    @Test
    public void testDryerDescriptors() {
        Dryer d = new Dryer();
        LinkedList<String> des = d.descriptors();
        assertTrue(des.contains(d.getColor() + ""));
        assertTrue(des.contains(d.getSize() + ""));
        assertTrue(des.contains("Top Load"));
        assertFalse(des.contains("Front Load"));
        assertFalse(des.contains("With Steamer"));
        d.setTopLoadDryer(false);
        d.setSteamer(true);
        des = d.descriptors();
        assertTrue(des.contains("Front Load"));
        assertTrue(des.contains("With Steamer"));
        assertFalse(des.contains("Top Load"));
    }

    @Test
    public void testDryerOptions() {
        Dryer d = new Dryer();
        LinkedList<String> des = d.options();
        assertTrue(des.contains("Top Load"));
        assertTrue(des.contains("Front Load"));
        assertTrue(des.contains("Steamer"));
    }
}