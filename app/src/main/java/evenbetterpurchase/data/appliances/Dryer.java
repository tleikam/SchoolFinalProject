package evenbetterpurchase.data.appliances;

import evenbetterpurchase.data.enums.Color;
import evenbetterpurchase.data.enums.DryerSize;
import java.util.LinkedList;

/**
 * Dryer Class.
 *
 *<p>This class creates an Object of Dryer, an
 appliance.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class Dryer extends Appliance {

    private boolean topLoadDryer;
    private boolean steamer;
    private DryerSize size;
    private Color color;
    private double price;

    /**
     * Constructor for Dryer.
     */
    public Dryer() {
        this.topLoadDryer = true;
        this.steamer = false;
        this.setSize(DryerSize.SEVENPOINTTHREE);
        this.setColor(Color.WHITE);
        this.setPrice();
    }

    /**
     * Formatter for URL.
     */
    public String getLink() {
        return "dryer";
    }

    /**
     * Price Getter.
     *
     * @return returns the value of the Dryer.
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
        double current = 349.99;
        current += this.getSize().getValue();
        if (this.getSteamer()) {
            current += 300.0;
        }
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
     * @return returns color of Dryer.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Color Setter.
     *
     * @param color sets the color for Dryer.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * TopLoad Getter.
     *
     * @return returns if dryer is topload.
     */
    public boolean getTopLoadDryer() {
        return this.topLoadDryer;
    }

    /**
     * TopLoad Setter.
     *
     * @param value value for if dryer is topload.
     */
    public void setTopLoadDryer(boolean value) {
        this.topLoadDryer = value;
        this.setPrice();
    }

    /**
     * Steamer Getter.
     *
     * @return returns if dryer has a steamer.
     */
    public boolean getSteamer() {
        return this.steamer;
    }

    /**
     * Steamer Setter.
     *
     * @param value value for if dryer has Steamer.
     */
    public void setSteamer(boolean value) {
        this.steamer = value;
        this.setPrice();
    }

    /**
     * Size Getter.
     *
     * @return returns size of Dryer.
     */
    public DryerSize getSize() {
        return this.size;
    }

    /**
     * Size Setter.
     *
     * @param size Size of the dryer.
     */
    public void setSize(DryerSize size) {
        this.size = size;
        this.setPrice();
    }

    /**
     * ToString Override.
     *
     * <p>Overrides the toString for Dryer
     *
     * @return  toString of Dryer with formatting with size and color
     */
    @Override
    public String toString() {
        return "" + this.getSize() + " cu. ft. " + this.getColor() + " Dryer";
    }

    /**
     * Method to return a generic name.
     */
    public String getName() {
        return "Dryer";
    }

    /**
     * Equals Override.
     *
     * <p>Overrides the Equals to determine whether an input is an original instance of
     the Dryer
     *
     * @param input instance of an object to see if it is an instance of Dryer
     * @return  boolean value determining if it is an original instance of Dryer
     */
    @Override
    public boolean equals(Object input) {
        if (input instanceof Dryer) {
            Dryer other = (Dryer) input;
            return this.getSize() == other.getSize()
                && this.getColor() == other.getColor()
                && this.getTopLoadDryer() == other.getTopLoadDryer()
                && this.getSteamer() == other.getSteamer();
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
        if (this.topLoadDryer) {
            descriptors.add("Top Load");
        } else {
            descriptors.add("Front Load");
        }
        if (this.steamer) {
            descriptors.add("With Steamer");
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
        options.add("Top Load");
        options.add("Front Load");
        options.add("Steamer");
        return options;
    }
}