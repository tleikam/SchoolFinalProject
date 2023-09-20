package evenbetterpurchase.data.appliances;

import evenbetterpurchase.data.enums.Color;
import evenbetterpurchase.data.enums.WasherSize;
import java.util.LinkedList;

/**
 * Washer Class.
 *
 *<p>This class creates an Object of Washer, an
 appliance.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class Washer extends Appliance {

    private boolean topLoadWasher;
    private WasherSize size;
    private Color color;
    private double price;

    /**
     * Constructor for Washer.
     */
    public Washer() {
        this.topLoadWasher = true;
        this.setSize(WasherSize.FOURPOINTFIVE);
        this.setColor(Color.WHITE);
        this.setPrice();
    }

    /**
     * Formatter for URL.
     */
    public String getLink() {
        return "washer";
    }

    /**
     * Price Getter.
     *
     * @return returns the value of the Washer.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Price Setter.
     *
     *<p>This is a default setter that goes throught the state of
     the object to determine the price.
     *
     */
    public void setPrice() {
        double current = 199.99;
        current += this.getSize().getValue();
        this.price = current;
    }

    /**
     * Price Setter with Discount.
     *
     *<p>This is a discount setter that goes throught the current
     price of the object, calculates the discount which is accessed
     from a discount class, and updates the current state of the 
     price.
     *
     * @param discount String to determine which discount to be applied
     */
    public void setPrice(String discount) {
        if (discount.equals("75 percent")) {
            double current = this.price;
            double value = current * .75;
            this.price = Double.parseDouble(String.format(".2f", (current - value)));   
        }
    }

    /**
     * Color Getter.
     *
     * @return returns color of Washer.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Color Setter.
     *
     * @param color sets the color for Washer.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * TopLoad Getter.
     *
     * @return returns if washer is topload.
     */
    public boolean getTopLoadWasher() {
        return this.topLoadWasher;
    }

    /**
     * TopLoad Setter.
     *
     * @param value value for if washer is topload.
     */
    public void setTopLoadWasher(boolean value) {
        this.topLoadWasher = value;
    }

    /**
     * Size Getter.
     *
     * @return returns size of washer.
     */
    public WasherSize getSize() {
        return this.size;
    }

    /**
     * Size Setter.
     *
     * @param size Size of the washer.
     */
    public void setSize(WasherSize size) {
        this.size = size;
    }

    /**
     * To String method for Washer.
     */
    @Override
    public String toString() {
        if (this.topLoadWasher) {
            return this.getSize() + " cu. ft. " + this.getColor() + " Top Load Washer";
        } else {
            return this.getSize() + " cu. ft. " + this.getColor() + " Front Load Washer";
        }   
    }

    /**
     * Method to return a generic name.
     */
    public String getName() {
        return "Washer";
    }

    /**
     * Equals Override.
     *
     * <p>Overrides the Equals to determine whether an input is an original instance of
     the Washer
     *
     * @param input instance of an object to see if it is an instance of Washer
     * @return  boolean value determining if it is an original instance of Washer
     */
    @Override
    public boolean equals(Object input) {
        if (input instanceof Washer) {
            Washer other = (Washer) input;
            return this.getSize() == other.getSize()
                && this.getColor() == other.getColor()
                && this.getTopLoadWasher() == other.getTopLoadWasher();
        } else {
            return false;
        }
    }

    /**
     * Descriptors for the Item.
     *
     * <p>This is a list of features that the item possesses. 
     *
     * @return  returns a linkedlist of strings added by the method
     */
    public LinkedList<String> descriptors() {
        LinkedList<String> descriptors = new LinkedList<>();
        descriptors.add(this.getColor() + "");
        descriptors.add(this.getSize() + "");
        if (this.topLoadWasher) {
            descriptors.add("Top Load Washer");
        } else {
            descriptors.add("Front Load Washer");
        }
        return descriptors;
    }

    /**
     * Options Method.
     *
     *<p>This method creates a LinkedList of all available options 
     for the item.
     *
     * @return LinkedList of available options for item
     */
    public LinkedList<String> options() {
        LinkedList<String> options = new LinkedList<>();
        options.add("Top Load or Front Load");
        return options;
    }
}