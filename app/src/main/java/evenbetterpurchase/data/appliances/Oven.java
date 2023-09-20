package evenbetterpurchase.data.appliances;

import evenbetterpurchase.data.enums.Color;
import java.util.LinkedList;

/**
 * Oven Class.
 *
 *<p>This class creates an Object of Oven, an
 appliance.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class Oven extends Appliance {

    private boolean electricOven;
    private boolean electricStoveTop;
    private Color color;
    private double price;

    /**
     * Constructor for Oven.
     */
    public Oven() {
        this.electricStoveTop = true;
        this.electricOven = true;
        this.setColor(Color.STAINLESS_STEEL);
        this.setPrice();
    }

    /**
     * Formatter for URL.
     */
    public String getLink() {
        return "oven";
    }

    /**
     * Price Getter.
     *
     * @return returns the value of the Oven.
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
        double current = 599.99;
        if (!(this.getElectricStoveTop())) {
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
     * @return returns color of Oven.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Color Setter.
     *
     * @param color sets the color for Oven.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * ElectricStoveTop Getter.
     *
     * @return returns if dryer is ElectricStoveTop.
     */
    public boolean getElectricStoveTop() {
        return this.electricStoveTop;
    }

    /**
     * ElectricStoveTop Setter.
     *
     * @param value value for if dryer is ElectricStoveTop.
     */
    public void setElectricStoveTop(boolean value) {
        this.electricStoveTop = value;
        this.setPrice();
    }

    /**
     * ElectricOven Getter.
     *
     * @return returns if dryer has a ElectricOven.
     */
    public boolean getElectricOven() {
        return this.electricOven;
    }

    /**
     * ElectricOven Setter.
     *
     * @param value value for if dryer has ElectricOven.
     */
    public void setElectricOven(boolean value) {
        this.electricOven = value;
        this.setPrice();
    }

    @Override
    public String toString() {
        if (electricStoveTop && electricOven) {
            return this.getColor() + " Electric Oven with Electric Stove Top";
        } else if (electricStoveTop && !(electricOven)) {
            return this.getColor() + " Gas Oven with Electric Stove Top";
        } else if (!(electricStoveTop) && electricOven) {
            return this.getColor() + " Electric Oven with Gas Stove Top";
        } else {
            return this.getColor() + " Gas Oven with Gas Stove Top";
        }
        
    }

    /**
     * Method to return a generic name.
     */
    public String getName() {
        return "Oven";
    }

    /**
     * Equals Override.
     *
     * <p>Overrides the Equals to determine whether an input is an original instance of
     the Oven
     *
     * @param input instance of an object to see if it is an instance of Oven
     * @return  boolean value determining if it is an original instance of Oven
     */
    @Override
    public boolean equals(Object input) {
        if (input instanceof Oven) {
            Oven other = (Oven) input;
            return this.getColor() == other.getColor()
                && this.electricOven == other.electricOven
                && this.electricStoveTop == other.electricStoveTop;
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
        if (this.electricOven) {
            descriptors.add("Electric Oven");
        } else {
            descriptors.add("Gas Oven");
        }
        if (this.electricStoveTop) {
            descriptors.add("Electric Stove Top");
        } else {
            descriptors.add("Gas Stove Top");
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
        options.add("Electric or Gas Oven");
        options.add("Electric or Gas Stove Top");
        return options;
    }
}