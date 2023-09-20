package evenbetterpurchase.data.order;

import evenbetterpurchase.data.Item;
import evenbetterpurchase.data.bundles.ApplianceDiscount;
import evenbetterpurchase.data.bundles.HomeTheaterDiscount;
import java.lang.IllegalArgumentException;
import java.lang.Iterable;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Class to keep track of current order.
 */
public class Order implements Iterable<Item> {

    private LinkedList<Item> orders;
    private static double taxRate = 0.115;

    /**
     * Order Constructor.
     *
     *<p>This Constructor instanciates a LinkedList in an
     iterable set
     */
    public Order() {
        this.orders = new LinkedList<>();
        // Should i make this a singleton, if not, why
    }

    /**
     * Getter for list of order.
     *
     * @return LinkedList of order.
     */
    public LinkedList<Item> getOrder() {
        return this.orders;
    }

    /**
     * Method to add Item.
     *
     * @param item item to add to the list of order
     */
    public void addItem(Item item) {
        this.orders.add(item);
    }

    /**
     * Contains method.
     *
     *<p>This method takes an item as a parameter and
     checks to see if its contained in the order
     returning the boolean value equavilent to
     the outcome.
     *
     * @param item Item to be check if its contained
     * @return the value of it being contained in order
     */
    public boolean containsItem(Item item) {
        for (Item current : this.orders) {
            if (current.equals(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to remove Item.
     *
     * @param item item to remove from the list of order
     */
    public void removeItem(Item item) {
        for (Item current : this.orders) {
            if (current.equals(item)) {
                orders.remove(current);
            }
        }
    }

    /**
     * Static method to getTax value.
     *
     * @return returns the current tax taxRate
     */
    public static double getTaxRate() {
        return taxRate;
    }

    /**
     * Static method to setTax value.
     *
     * @param value sets the taxRate to value
     * @throws IllegalArgumentException if tax rate is below 0 or above 1
     */
    public static void setTaxRate(double value) {
        if (value < 1.0
                && value > 0.0) {
            taxRate = value;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Method to calculate subtotal of items in order.
     *
     * @return subtotal cost of items in order
     */
    public double getSubTotal() {
        double subTotal = 0.0;
        for (Item item : orders) {
            subTotal += item.getPrice();
        }
        return subTotal;
    }

    /**
     * Getter for total tax for order.
     *
     * @return Total tax amount for order
     */
    public double getTotalTax() {
        double subTotal = getSubTotal();
        double tax = subTotal * getTaxRate();
        String formatter = String.format("%.2f", tax);
        double formattedtax = Double.parseDouble(formatter);
        return formattedtax;
    }

    /**
     * Method to get Total cost of order.
     *
     * @return Total cost of the order
     */
    public double getTotalCost() {
        ApplianceDiscount.discount(this.orders);
        HomeTheaterDiscount.discount(this.orders);
        String formattedCost = String.format("%.2f", (getSubTotal() + getTotalTax()));
        return Double.parseDouble(formattedCost);
    }

    /**
     * Method overrides and creates an iterator of orders.
     */
    @Override
    public Iterator<Item> iterator() {
        return this.orders.iterator();
    }

    /**
     * Getter for size of orders.
     *
     * @return int value of orders size
     */
    public int size() {
        return this.orders.size();
    }

    /**
     * Getter for Order in index value.
     *
     * @param i     index value to get an order
     */
    public Item get(int i) {
        return this.orders.get(i);
    }
}