package evenbetterpurchase.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import evenbetterpurchase.data.appliances.DishWasher;
import evenbetterpurchase.data.appliances.Dryer;
import evenbetterpurchase.data.appliances.Oven;
import evenbetterpurchase.data.appliances.Refrigerator;
import evenbetterpurchase.data.appliances.Washer;
import evenbetterpurchase.data.hometheater.HomeAudio;
import evenbetterpurchase.data.hometheater.Television;
import java.io.File;
import java.lang.Iterable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Cart Class.
 *
 *<p>This class is a container for the items added to a cart,
 and works as a singleton so the application can only load one.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class CartList implements Iterable<Item> {

    private List<Item> items;
    private static CartList instance = null;

    /**
     * Constructor for the Cart List.
     */
    private CartList() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            /*
            this.items = mapper.readValue(new File("cart.json"),
                                          new TypeReference<List<Item>>(){});
            */
            this.items = new LinkedList<>();
            System.out.println("Successfully loaded file");
        } catch (Exception e) {
            System.err.println("Unable to parse Cart file!");
            e.printStackTrace();
            this.items = new LinkedList<>();
        }
    }

    /**
     * Static getter for singleton.
     *
     * @return Cart Singleton Instance
     */
    public static CartList getInstance() {
        if (CartList.instance == null) {
            CartList.instance = new CartList();
        }
        return CartList.instance;
    }

    /**
     * Method to iterate over items.
     *
     * @return an iterator of items
     */
    @Override
    public Iterator<Item> iterator() {
        return items.iterator();
    }

    /**
     * Method to get Size of items.
     *
     * @return the number of items
     */
    public int size() {
        return items.size();
    }

    /**
     * Get a single item.
     *
     * @param i the index of the item
     * @return the item
     */
    public Item get(int i) {
        return items.get(i);
    }

    /**
     * Updater for a single item.
     *
     * @param i the index of the item
     */
    public void set(int i, Item item) {
        items.set(i, item);
    }

    /**
     * Add an item to the list.
     *
     * @param item Item to add
     */
    public void add(Item item) {
        items.add(item);
    }

    /**
     * Delete a single item.
     *
     * @param i the index of the item 
     */
    public void delete(int i) {
        items.remove(i);
    }

    /**
     * Save method.
     *
     *<p>This class saves the current cart of items to JSON
     for serialization.
     */
    public void save() {
        try {
            File file = new File("cart.json");
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("Saving Cart");
            mapper.writeValue(file, this.items);
            System.out.println("Saved cart");
        } catch (Exception e) {
            System.err.println("Not Saved: Unable to write to 'cart.json'");
            e.printStackTrace();
        }
    }
}