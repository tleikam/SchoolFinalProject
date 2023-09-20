package evenbetterpurchase.data;

import java.util.LinkedList;

/**
 * Interface for items.
 */
public interface Item {

    abstract double getPrice();

    abstract String getLink();

    abstract LinkedList<String> descriptors();

    abstract LinkedList<String> options();
}