package evenbetterpurchase.order;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import evenbetterpurchase.data.Item;
import evenbetterpurchase.data.appliances.Appliance;
import evenbetterpurchase.data.appliances.DishWasher;
import evenbetterpurchase.data.appliances.Dryer;
import evenbetterpurchase.data.appliances.Oven;
import evenbetterpurchase.data.appliances.Refrigerator;
import evenbetterpurchase.data.appliances.Washer;
import evenbetterpurchase.data.hometheater.Television;
import evenbetterpurchase.data.order.Order;
import java.lang.IllegalArgumentException;
import java.lang.Iterable;
import java.util.Iterator;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

/**
 * Test Class for Order.
 *
 * @author Travis Leikam
 * @version 0.1
 */
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
public class OrderTest {

    @Mock
    Television mock1;
    @Mock
    Dryer mock2;

    @Test
    public void testOrderConstructsProperly() {
        Order order = new Order();
        assertThat(order.size(), is(0));
        assertThat(order.getSubTotal(), is(0.0));
        assertThat(order.getTotalTax(), is(0.0));
    }

    @Test
    public void testOrderTaxCannotBeAboveOne() {
        Order order = new Order();
        assertThrows(IllegalArgumentException.class, () -> order.setTaxRate(1.01));
    }
    
    @Test
    public void testOrderTaxCannotBeBelowZero() {
        Order order = new Order();
        assertThrows(IllegalArgumentException.class, () -> order.setTaxRate(-0.01));
    }

    @Test
    public void testOrderTaxIsGlobal() {
        Order order = new Order();
        Order order2 = new Order();
        assertEquals(0.115, order.getTaxRate());
        assertEquals(0.115, order2.getTaxRate());
        order.setTaxRate(0.081);
        assertEquals(0.081, order.getTaxRate());
        assertEquals(0.081, order2.getTaxRate());
        order.setTaxRate(0.115);
        
    }

    @Test
    public void testAddingItemAndRemovingItemOrderSize() {
        Order order = new Order();
        assertTrue(order.size() == 0);
        order.addItem(mock1);
        assertTrue(order.size() == 1);
        assertTrue(order.containsItem(mock1));
        order.removeItem(mock1);
        assertTrue(order.size() == 0);
        assertFalse(order.containsItem(mock1));
    }

    @Test
    public void testOrderContainsItem() {
        Order order = new Order();
        order.addItem(mock1);
        assertTrue(order.containsItem(mock1));
    }

    @Test
    public void testOrderDoesntContainItem() {
        Order order = new Order();
        order.addItem(mock1);
        assertFalse(order.containsItem(mock2));
    }

    @Test
    public void testOrderGetReturnsCorrectItem() {
        Order order = new Order();
        order.addItem(mock1);
        order.addItem(mock2);
        assertThat(order.get(0), is(mock1));
        assertThat(order.get(1), is(mock2));
    }

    @Test
    public void testOrderSubTotalReturnsCorrectly() {
        when(mock1.getPrice()).thenReturn(100.25);
        when(mock2.getPrice()).thenReturn(99.75);
        Order order = new Order();
        order.addItem(mock1);
        order.addItem(mock2);
        assertThat(order.getSubTotal(), is(200.0));
    }

    @Test
    public void testOrderTotalIsCorrect() {
        when(mock1.getPrice()).thenReturn(10.00);
        Order order = new Order();
        order.addItem(mock1);
        assertThat(order.getTotalCost(), is(11.15));
    }

    @Test
    public void testOrderIteratorReturnsCorrectly() {
        Order order = new Order();
        Iterator<Item> its = order.iterator();
        assertTrue(its instanceof Iterator);
    }
}
