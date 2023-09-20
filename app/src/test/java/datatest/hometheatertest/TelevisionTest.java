package datatest.hometheatertest;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import evenbetterpurchase.data.Item;
import evenbetterpurchase.data.appliances.Dryer;
import evenbetterpurchase.data.enums.TvSize;
import evenbetterpurchase.data.hometheater.Television;
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
public class TelevisionTest {
    
    @Test
    public void testTelevisionIsAnItem() {
        Television t = new Television();
        assertTrue(t instanceof Item);
    }

    @Test
    public void testTelevisionConstructor() {
        Television t = new Television();
        assertThat(t.getSize(), is(TvSize.FIFTYFIVE));
        assertFalse(t.getOled());
    }

    @Test
    public void testTelevisionGetAndSetPrice() {
        Television t = new Television();
        assertThat(t.getPrice(), is(549.99));
        t.setOled(true);
        assertThat(t.getPrice(), is(749.99));
        t.setSize(TvSize.SEVENTYFIVE);
        assertThat(t.getPrice(), is(1049.99));
    }

    @Test
    public void testTelevisionDiscount() {
        Television t = new Television();
        double temp = t.getPrice();
        t.setPrice("discount");
        assertTrue(temp >= t.getPrice());
    }

    @Test
    public void testTelevisionDiscountWrongString() {
        Television t = new Television();
        double temp = t.getPrice();
        t.setPrice("FREE");
        assertTrue(temp == t.getPrice());
    }

    @Test
    public void testTelevisionGetAndSetOled() {
        Television t = new Television();
        assertFalse(t.getOled());
        t.setOled(true);
        assertTrue(t.getOled());
    }

    @Test
    public void testTelevisionTvSizeSetter() {
        Television t = new Television();
        assertThat(t.getSize(), is(TvSize.FIFTYFIVE));
        t.setSize(TvSize.THIRTYTWO);
        assertThat(t.getSize(), is(TvSize.THIRTYTWO));
        t.setSize(TvSize.FOURTYTHREE);
        assertThat(t.getSize(), is(TvSize.FOURTYTHREE));
        t.setSize(TvSize.SIXTYFIVE);
        assertThat(t.getSize(), is(TvSize.SIXTYFIVE));
        t.setSize(TvSize.SEVENTYFIVE);
        assertThat(t.getSize(), is(TvSize.SEVENTYFIVE));
    }

    @Test
    public void testTelevisionToString() {
        Television t = new Television();
        assertThat(t.toString(), is(t.getSize() + " TV"));
        t.setOled(true);
        assertThat(t.toString(), is(t.getSize() + " OLED TV"));
    }

    @Test
    public void testTelevisionGetName() {
        Television t = new Television();
        assertThat(t.getName(), is("Television"));
    }

    @Test
    public void testTelevisionEqualsMethod() {
        Television t = new Television();
        Television other = new Television();
        Dryer d = new Dryer();
        assertTrue(t.equals(other));
        assertFalse(t.equals(d));
        other.setSize(TvSize.FOURTYTHREE);
        assertFalse(t.equals(other));
        other.setSize(TvSize.FIFTYFIVE);
        other.setOled(true);
        assertFalse(t.equals(other));
    }

    @Test
    public void testTelevisionDescriptors() {
        Television t = new Television();
        LinkedList<String> d = t.descriptors();
        assertTrue(d.contains("55\""));
        assertFalse(d.contains("OLED"));
        t.setOled(true);
        d = t.descriptors();
        assertTrue(d.contains("OLED"));
    }

    @Test
    public void testTelevisionOptions() {
        Television t = new Television();
        LinkedList<String> d = t.options();
        assertTrue(d.contains("32\""));
        assertTrue(d.contains("43\""));
        assertTrue(d.contains("55\""));
        assertTrue(d.contains("65\""));
        assertTrue(d.contains("75\""));
        assertTrue(d.contains("OLED Available"));
    }
}