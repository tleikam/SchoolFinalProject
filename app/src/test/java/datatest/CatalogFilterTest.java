package evenbetterpurchase.datatest;

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

import evenbetterpurchase.data.CatalogFilter;
import evenbetterpurchase.data.Item;
import evenbetterpurchase.data.appliances.Appliance;
import evenbetterpurchase.data.appliances.DishWasher;
import evenbetterpurchase.data.appliances.Dryer;
import evenbetterpurchase.data.appliances.Oven;
import evenbetterpurchase.data.appliances.Refrigerator;
import evenbetterpurchase.data.appliances.Washer;
import evenbetterpurchase.data.order.Order;
import java.lang.IllegalArgumentException;
import java.lang.Iterable;
import java.util.Iterator;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

/**
 * Test Class for Catalog Filter.
 *
 * @author Travis Leikam
 * @version 0.1
 */
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
public class CatalogFilterTest {

    @Mock
    Item mock1;
    @Mock
    Item mock2;
    @Mock
    Item mock3;

    @Test
    public void testCatalogFilterKeywordNull() {
        LinkedList<Item> items = new LinkedList<>();
        items.add(mock1);
        items.add(mock2);
        items.add(mock3);
        assertTrue(items.size() == 3);
        items = CatalogFilter.filterKeywords(items, null);
        assertTrue(items.size() == 3);
    }

    @Test
    public void testCatalogFilterKeywordEmptyString() {
        LinkedList<Item> items = new LinkedList<>();
        items.add(mock1);
        items.add(mock2);
        items.add(mock3);
        assertTrue(items.size() == 3);
        items = CatalogFilter.filterKeywords(items, "");
        assertTrue(items.size() == 3);
    }

    @Test
    public void testCatalogFilterKeywordWorks() {
        when(mock1.toString()).thenReturn("it's a trap");
        when(mock2.toString()).thenReturn("I have the High Ground");
        when(mock3.toString()).thenReturn("Beep Boop");
        LinkedList<Item> items = new LinkedList<>();
        items.add(mock1);
        items.add(mock2);
        items.add(mock3);
        assertTrue(items.size() == 3);
        items = CatalogFilter.filterKeywords(items, "trap");
        assertTrue(items.size() == 1);
    }

    @Test
    public void testCatalogFilterKeywordDoesntEnterSameEntry() {
        when(mock1.toString()).thenReturn("it's a trap");
        when(mock2.toString()).thenReturn("I have the High Ground");
        when(mock3.toString()).thenReturn("Beep Boop");
        LinkedList<Item> items = new LinkedList<>();
        items.add(mock1);
        items.add(mock1);
        items.add(mock2);
        items.add(mock3);
        assertTrue(items.size() == 4);
        items = CatalogFilter.filterKeywords(items, "trap");
        assertTrue(items.size() == 1);
        assertTrue(items.contains(mock1));
    }

    @Test
    public void testCatalogFilterAddsItemIfOptionContainsKeyword() {
        LinkedList<String> op = new LinkedList<>();
        op.add("It's a trap");
        when(mock1.options()).thenReturn(op);
        when(mock1.toString()).thenReturn("Dont say the word");
        LinkedList<Item> items = new LinkedList<>();
        items.add(mock1);
        assertTrue(items.size() == 1);
        assertTrue(items.contains(mock1));
        items = CatalogFilter.filterKeywords(items, "trap");
        assertTrue(items.contains(mock1));
    }
}