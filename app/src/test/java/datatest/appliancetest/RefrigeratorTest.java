package datatest.appliancetest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import evenbetterpurchase.data.Item;
import evenbetterpurchase.data.appliances.Appliance;
import evenbetterpurchase.data.appliances.Dryer;
import evenbetterpurchase.data.appliances.Refrigerator;
import evenbetterpurchase.data.enums.Color;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Test Class for Refrigerator.
 *
 *<p>This class uses tests to ensure Refrigerator is functioning as intended.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class RefrigeratorTest {

    @Test
    public void testRefrigeratorIsAnAppliance() {
        Refrigerator d = new Refrigerator();
        assertTrue(d instanceof Appliance);
    }

    @Test
    public void testRefrigeratorIsAnItem() {
        Refrigerator d = new Refrigerator();
        assertTrue(d instanceof Item);
    }

    @Test
    public void testRefrigeratorConstructor() {
        Refrigerator d = new Refrigerator();
        assertTrue(d.getFrenchDoors());
        assertTrue(d.getLcdPanel());
        assertTrue(d.getDoubleDrawerFreezer());
        assertFalse(d.getSingleDrawerFreezer());
        assertTrue(d.getLcdPanel());
        assertTrue(d.getIceMaker());
        assertThat(d.getColor(), is(Color.STAINLESS_STEEL));
    }

    @Test
    public void testRefrigeratorHasCorrectPrice() {
        Refrigerator d = new Refrigerator();



    }

    @Test
    public void testRefrigeratorDiscountsCorrectly() {
        Refrigerator d = new Refrigerator();
        double temp = Double.parseDouble(String.format(".2f",
                            (d.getPrice() - (d.getPrice() * .75))));
        d.setPrice("75 percent");
        assertThat(d.getPrice(), is(temp));
    }

    @Test
    public void testRefrigeratorDoesntDiscountWithWrongString() {
        Refrigerator d = new Refrigerator();
        double temp = d.getPrice();
        d.setPrice("FREE");
        assertThat(d.getPrice(), is(temp));
    }

    @Test
    public void testRefrigeratorGetAndSetColorWorks() {
        Refrigerator d = new Refrigerator();
        assertThat(d.getColor(), is(Color.STAINLESS_STEEL));
        d.setColor(Color.BLACK);
        assertThat(d.getColor(), is(Color.BLACK));
        d.setColor(Color.WHITE);
        assertThat(d.getColor(), is(Color.WHITE));
        d.setColor(Color.BLUE);
        assertThat(d.getColor(), is(Color.BLUE));
    }

    @Test
    public void testRefrigeratorGetNameReturnsCorrectly() {
        Refrigerator d = new Refrigerator();
        assertThat(d.getName(), is("Refrigerator"));
    }

    @Test
    public void testRefrigeratorSetterAndGetter() {
        Refrigerator d = new Refrigerator();
        assertTrue(d.getFrenchDoors());
        d.setFrenchDoors(false);
        assertFalse(d.getFrenchDoors());
        assertTrue(d.getLcdPanel());
        d.setLcdPanel(false);
        assertTrue(d.getDoubleDrawerFreezer());
        assertFalse(d.getSingleDrawerFreezer());
        d.setDoubleDrawerFreezer(false);
        assertTrue(d.getSingleDrawerFreezer());
        assertFalse(d.getDoubleDrawerFreezer());
        d.setSingleDrawerFreezer(false);
        assertTrue(d.getDoubleDrawerFreezer());
        assertFalse(d.getSingleDrawerFreezer());
        assertTrue(d.getIceMaker());
        d.setIceMaker(false);
        assertFalse(d.getIceMaker());
    }

    @Test
    public void testRefrigeratorToString() {
        Refrigerator r = new Refrigerator();
        assertThat(r.toString(), is("Stainless Steel Refrigerator with French Doors"));
        r.setFrenchDoors(false);
        assertThat(r.toString(), is("Stainless Steel Refrigerator"));
    }

    @Test
    public void testRefrigeratorEqualsMethod() {
        Refrigerator d = new Refrigerator();
        Refrigerator other = new Refrigerator();
        Dryer notRefrigerator = new Dryer();
        assertTrue(d.equals(other));
        assertFalse(d.equals(notRefrigerator));
        other.setColor(Color.BLACK);
        assertFalse(d.equals(other));
        other.setColor(Color.STAINLESS_STEEL);
        other.setIceMaker(false);
        assertFalse(d.equals(other));
        other.setIceMaker(true);
        other.setFrenchDoors(false);
        assertFalse(d.equals(other));
        other.setFrenchDoors(true);
        other.setDoubleDrawerFreezer(false);
        assertFalse(d.equals(other));
        other.setSingleDrawerFreezer(false);
        assertTrue(d.equals(other));
    }

    @Test
    public void testRefrigeratorDescriptors() {
        Refrigerator d = new Refrigerator();
        LinkedList<String> des = d.descriptors();
        assertTrue(des.contains("Stainless Steel"));
        assertTrue(des.contains("With French Doors"));
        assertTrue(des.contains("With LCD Display"));
        assertTrue(des.contains("Double Drawer Freezer"));
        assertTrue(des.contains("With Ice Maker"));
        assertFalse(des.contains("Single Drawer Freezer"));
        d.setSingleDrawerFreezer(true);
        des = d.descriptors();
        assertTrue(des.contains("Single Drawer Freezer"));
        assertFalse(des.contains("Double Drawer Freezer"));
    }

    @Test
    public void testRefrigeratorOptions() {
        Refrigerator r = new Refrigerator();
        LinkedList<String> options = r.options();
        assertThat(options.size(), is(4));
        assertTrue(options.contains("Ice Maker"));
        assertTrue(options.contains("LCD Display"));
        assertTrue(options.contains("French or Single Door"));
        assertTrue(options.contains("Single or Double Freezer Drawer"));
    }
}