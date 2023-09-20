package evenbetterpurchase.data.appliances;

import evenbetterpurchase.data.enums.Color;
import java.util.LinkedList;

/**
 * DishWasher Class.
 *
 *<p>This class creates an Object of DishWasher, an
 appliance.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class DishWasher extends Appliance {

    private boolean thirdRack;
    private Color color;
    private double price;

    /**
     * Constructor for DishWasher.
     */
    public DishWasher() {
        this.thirdRack = true;
        this.setColor(Color.STAINLESS_STEEL);
        this.setPrice();
    }

    /**
     * Formatter for URL.
     */
    public String getLink() {
        return "dishwasher";
    }

    /**
     * Price Getter.
     *
     * @return returns the value of the Dishwasher.
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
        double current = 499.99;
        if (this.thirdRack) {
            current += 200.0;
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
     * @return returns color of dishwasher.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Color Setter.
     *
     * @param color sets the color for DishWasher.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * ThirdRack Getter.
     *
     * @return returns if dishwasher has a third rack.
     */
    public boolean getThirdRack() {
        return this.thirdRack;
    }

    /**
     * ThirdRack Setter.
     *
     * @param value value for if third rack is in DishWasher.
     */
    public void setThirdRack(boolean value) {
        this.thirdRack = value;
        this.setPrice();
    }

    /**
     * ToString Override.
     *
     * <p>Overrides the toString for DishWasher and formats for if the 
     third rack is included.
     *
     * @return  toString of DishWasher with formatting to include thirdrack provided
     */
    @Override
    public String toString() {
        if (thirdRack) {
            return "" + this.getColor() + " Dish Washer with Third Rack";
        } else {
            return "" + this.getColor() + " Dish Washer";
        }
    }

    /**
     * Method to return a generic name.
     */
    public String getName() {
        return "Dish Washer";
    }

    /**
     * Equals Override.
     *
     * <p>Overrides the Equals to determine whether an input is an original instance of
     the DishWasher
     *
     * @param input instance of an object to see if it is an instance of DishWasher
     * @return  boolean value determining if it is an original instance of DishWasher
     */
    @Override
    public boolean equals(Object input) {
        if (input instanceof DishWasher) {
            DishWasher other = (DishWasher) input;
            return this.getThirdRack() == other.getThirdRack()
                && this.getColor() == other.getColor();
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
        if (thirdRack) {
            descriptors.add("With third rack");
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
        options.add("Available with Third Rack");
        return options;
    }
}