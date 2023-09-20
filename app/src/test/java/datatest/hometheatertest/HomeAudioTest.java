package datatest.hometheatertest;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import evenbetterpurchase.data.Item;
import evenbetterpurchase.data.hometheater.HomeAudio;
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
public class HomeAudioTest {

    @Test
    public void testHomeAudioIsAnItem() {
        HomeAudio h = new HomeAudio();
        assertTrue(h instanceof Item);
    }

    @Test
    public void testHomeAudioConstructor() {
        HomeAudio h = new HomeAudio();
        assertFalse(h.getSub());
        assertFalse(h.getWireless());
    }

    @Test
    public void testHomeAudioGetAndSetPrice() {
        HomeAudio h = new HomeAudio();
        assertThat(h.getPrice(), is(299.99));
        h.setSub(true);
        assertThat(h.getPrice(), is(499.99));
        h.setWireless(true);
        assertThat(h.getPrice(), is(599.99));
    }

    @Test
    public void testHomeAudioGetAndSetAttributes() {
        HomeAudio h = new HomeAudio();
        assertFalse(h.getSub());
        h.setSub(true);
        assertTrue(h.getSub());
        assertFalse(h.getWireless());
        h.setWireless(true);
        assertTrue(h.getWireless());
    }

    @Test
    public void testHomeAudioGetsDiscount() {
        HomeAudio h = new HomeAudio();
        double temp = h.getPrice();
        h.setPrice("discount");
        assertTrue(temp >= h.getPrice());
    }

    @Test
    public void testHomeAudioNoDiscountWrongString() {
        HomeAudio h = new HomeAudio();
        double temp = h.getPrice();
        h.setPrice("FREE");
        assertTrue(temp == h.getPrice());
    }

    @Test
    public void testHomeAudioToString() {
        HomeAudio h = new HomeAudio();
        assertThat(h.toString(), is("Home Audio System"));
        h.setWireless(true);
        assertThat(h.toString(), is("Wireless Home Audio System"));
        h.setSub(true);
        assertThat(h.toString(), is("Wireless Home Audio System with Subwoofer"));
        h.setWireless(false);
        assertThat(h.toString(), is("Home Audio System with Subwoofer"));
    }

    @Test
    public void testHomeAudioGetName() {
        HomeAudio h = new HomeAudio();
        assertThat(h.getName(), is("Home Audio System"));
    }

    @Test
    public void testHomeAudioEqualsMethod() {
        HomeAudio h = new HomeAudio();
        HomeAudio other = new HomeAudio();
        Television t = new Television();
        assertTrue(h.equals(other));
        assertFalse(h.equals(t));
        other.setSub(true);
        assertFalse(h.equals(other));
        other.setSub(false);
        other.setWireless(true);
        assertFalse(h.equals(other));
    }

    @Test
    public void testHomeAudioDescriptors() {
        HomeAudio h = new HomeAudio();
        LinkedList<String> d = h.descriptors();
        assertTrue(d.size() == 0);
        h.setSub(true);
        h.setWireless(true);
        d = h.descriptors();
        assertTrue(d.contains("Wireless"));
        assertTrue(d.contains("With Sub"));
    }
    
    @Test
    public void testHomeAudioOptions() {
        HomeAudio h = new HomeAudio();
        LinkedList<String> d = h.options();
        assertTrue(d.contains("Wireless or Wired"));
        assertTrue(d.contains("With or Without Sub"));
    }
}