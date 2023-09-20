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
import evenbetterpurchase.data.appliances.Washer;
import evenbetterpurchase.data.enums.Color;
import evenbetterpurchase.data.enums.WasherSize;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Test class for Washer.
 *
 *<p>This class uses tests to ensure Washer is
 functioning as intended.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class WasherTest {

    @Test
    public void testWasherIsAnAppliance() {
        Washer w = new Washer();
        assertTrue(w instanceof Appliance);
    }

    @Test
    public void testWasherIsAnItem() {
        Washer w = new Washer();
        assertTrue(w instanceof Item);
    }

    @Test
    public void testWasherContructor() {
        Washer w = new Washer();
        assertTrue(w.getTopLoadWasher());
        assertThat(w.getSize(), is(WasherSize.FOURPOINTFIVE));
        assertThat(w.getColor(), is(Color.WHITE));
    }

    @Test
    public void testWasherHasCorrectPrice() {
        Washer w = new Washer();



    }

    @Test
    public void testWasherDiscountsCorrectly() {
        Washer w = new Washer();
        double temp = Double.parseDouble(String.format(".2f",
                            (w.getPrice() - (w.getPrice() * .75))));
        w.setPrice("75 percent");
        assertThat(w.getPrice(), is(temp));
    }

    @Test
    public void testWasherDoesntDiscountWithWrongString() {
        Washer w = new Washer();
        double temp = w.getPrice();
        w.setPrice("FREE");
        assertThat(w.getPrice(), is(temp));
    }

    @Test
    public void testWasherGetAndSetColorWorks() {
        Washer w = new Washer();
        assertThat(w.getColor(), is(Color.WHITE));
        w.setColor(Color.BLACK);
        assertThat(w.getColor(), is(Color.BLACK));
        w.setColor(Color.STAINLESS_STEEL);
        assertThat(w.getColor(), is(Color.STAINLESS_STEEL));
        w.setColor(Color.BLUE);
        assertThat(w.getColor(), is(Color.BLUE));
    }

    @Test
    public void testTopLoadWasherGetterAndSetter() {
        Washer w = new Washer();
        assertTrue(w.getTopLoadWasher());
        w.setTopLoadWasher(false);
        assertFalse(w.getTopLoadWasher());
    }

    @Test
    public void testWasherSizeSetChangesAccordingly() {
        Washer w = new Washer();
        assertThat(w.getSize(), is(WasherSize.FOURPOINTFIVE));
        w.setSize(WasherSize.FIVEPOINTZERO);
        assertThat(w.getSize(), is(WasherSize.FIVEPOINTZERO));
        w.setSize(WasherSize.FIVEPOINTFIVE);
        assertThat(w.getSize(), is(WasherSize.FIVEPOINTFIVE));
        w.setSize(WasherSize.SIXPOINTZERO);
        assertThat(w.getSize(), is(WasherSize.SIXPOINTZERO));
    }

    @Test
    public void testWasherGetNameReturnsCorrectly() {
        Washer w = new Washer();
        assertThat(w.getName(), is("Washer"));
    }

    @Test
    public void testWasherToStringReturnsCorrectly() {
        Washer w = new Washer();
        assertThat(w.toString(), is("4.5 cu. ft. White Top Load Washer"));
        w.setColor(Color.BLACK);
        assertThat(w.toString(), is("4.5 cu. ft. Black Top Load Washer"));
        w.setTopLoadWasher(false);
        assertThat(w.toString(), is("4.5 cu. ft. Black Front Load Washer"));
        w.setSize(WasherSize.FIVEPOINTZERO);
        assertThat(w.toString(), is("5.0 cu. ft. Black Front Load Washer"));
    }

    @Test
    public void testEqualsMethodWorksCorrectly() {
        Washer w = new Washer();
        Washer other = new Washer();
        assertTrue(w.equals(other));
        other.setColor(Color.BLACK);
        assertFalse(w.equals(other));
        other.setColor(Color.WHITE);
        assertTrue(w.equals(other));
        other.setTopLoadWasher(false);
        assertFalse(w.equals(other));
        other.setTopLoadWasher(true);
        other.setSize(WasherSize.SIXPOINTZERO);
        assertFalse(w.equals(other));        
        DishWasher notWasher = new DishWasher();
        assertFalse(w.equals(notWasher));
    }

    @Test
    public void testDescriptors() {
        Washer w = new Washer();
        LinkedList<String> d = w.descriptors();
        assertTrue(d.contains(w.getColor() + ""));
        assertTrue(d.contains(w.getSize() + ""));
        assertTrue(d.contains("Top Load Washer"));
        w.setTopLoadWasher(false);
        d = w.descriptors();
        assertFalse(d.contains("Top Load Washer"));
        assertTrue(d.contains("Front Load Washer"));
    }

    @Test
    public void testWasherOptions() {
        Washer w = new Washer();
        LinkedList<String> d = w.options();
        assertTrue(d.contains("Top Load or Front Load"));
    }
}