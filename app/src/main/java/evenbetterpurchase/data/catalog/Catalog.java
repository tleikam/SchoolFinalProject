package evenbetterpurchase.data.catalog;

import evenbetterpurchase.data.Item;
import evenbetterpurchase.data.appliances.Appliance;
import evenbetterpurchase.data.appliances.DishWasher;
import evenbetterpurchase.data.appliances.Dryer;
import evenbetterpurchase.data.appliances.Oven;
import evenbetterpurchase.data.appliances.Refrigerator;
import evenbetterpurchase.data.appliances.Washer;
import evenbetterpurchase.data.hometheater.HomeAudio;
import evenbetterpurchase.data.hometheater.Television;
import java.lang.Iterable;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Class for listing all items in the catalog.
 */
public final class Catalog implements Iterable<Item> {

    public LinkedList<Item> appliances;
    public LinkedList<Item> hometheater;
    public LinkedList<Item> allItems;

    /**
     * Constructor for the Catalog.
     */
    public Catalog() {
        this.appliances = this.getAppliances();
        this.hometheater = this.getHomeTheater();
        this.allItems = this.getAllItems();
    }

    /**
     * Method to put all appliances into a list.
     *
     * @return LinkedList containing all appliances
     */
    public static LinkedList<Item> getAppliances() {
        LinkedList<Item> appliances = new LinkedList<>();
        appliances.add(new DishWasher());
        appliances.add(new Dryer());
        appliances.add(new Oven());
        appliances.add(new Refrigerator());
        appliances.add(new Washer());
        return appliances;
    }

    /**
     * Method to put all hometheater items in a list.
     *
     * @return List of hometheater items.
     */
    public static LinkedList<Item> getHomeTheater() {
        LinkedList<Item> hometheater = new LinkedList<>();
        hometheater.add(new Television());
        hometheater.add(new HomeAudio());
        return hometheater;
    }

    /**
     * Method to put all items in a list.
     *
     * @return full list of all items.
     */
    public static LinkedList<Item> getAllItems() {
        LinkedList<Item> allItems = new LinkedList<>();
        allItems.add(new DishWasher());
        allItems.add(new Dryer());
        allItems.add(new Oven());
        allItems.add(new Refrigerator());
        allItems.add(new Washer());
        allItems.add(new Television());
        allItems.add(new HomeAudio());
        return allItems;
    }

    /**
     * Method to iterate over items.
     *
     * @return an iterator for items.
     */
    @Override
    public Iterator<Item> iterator() {
        return allItems.iterator();
    }

    /**
     * The number of Items.
     *
     * @return the number of items.
     */
    public int size() {
        return allItems.size();
    }
}