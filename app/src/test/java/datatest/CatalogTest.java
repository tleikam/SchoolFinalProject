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
import evenbetterpurchase.data.catalog.Catalog;
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
 * Test Class for Catalog.
 *
 * @author Travis Leikam
 * @version 0.1
 */
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
public class CatalogTest {

    @Test
    public void testCatalogHasCorrectNumberOfItems() {
        Catalog cat = new Catalog();
        LinkedList<Item> allItems = cat.getAllItems();
        assertTrue(allItems.size() == 7);
    }

    @Test
    public void testCatalogHasCorrectAmountOfAppliances() {
        Catalog cat = new Catalog();
        LinkedList<Item> appliances = cat.getAppliances();
        assertTrue(appliances.size() == 5);
    }

    @Test
    public void testCatalogHasCorrectAmountOfHomeTheaterItems() {
        Catalog cat = new Catalog();
        LinkedList<Item> home = cat.getHomeTheater();
        assertTrue(home.size() == 2);
    }

    @Test
    public void testCatalogIteratorReturnsCorrectSize() {
        Catalog cat = new Catalog();
        assertThat(cat.size(), is(7));
    }

    @Test
    public void testCatalogIteratorReturnsCorrectly() {
        Catalog cat = new Catalog();
        Iterator<Item> its = cat.iterator();
        assertTrue(its instanceof Iterator);
    }
}