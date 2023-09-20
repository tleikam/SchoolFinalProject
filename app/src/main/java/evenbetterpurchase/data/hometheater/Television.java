package evenbetterpurchase.data.hometheater;

import evenbetterpurchase.data.Item;
import evenbetterpurchase.data.enums.TvSize;
import java.util.LinkedList;

/**
 * Class for Television.
 */
public class Television implements Item {

    private TvSize size;
    private boolean oled;
    private double price;

    /**
     * Constructor for television.
     */
    public Television() {
        this.setSize(TvSize.FIFTYFIVE);
        this.oled = false;
        this.setPrice();
    }

    /**
     * Formatter for URL.
     */
    public String getLink() {
        return "television";
    }

    /**
     * Price Getter.
     *
     * @return returns the value of the Television.
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
        double current = 99.99;
        current += size.getValue();
        if (this.getOled()) {
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
        if (discount.equals("discount")) {
            double current = this.getPrice();
            double value = current * .2;
            this.price = Double.parseDouble(String.format(".2f", (current - value))); 
        }
    }

    /**
     * Size Getter.
     *
     * @return returns the Size of the Television.
     */
    public TvSize getSize() {
        return this.size;
    }

    /**
     * Size Setter.
     *
     * @param value sets the Size for Tv.
     */
    public void setSize(TvSize value) {
        this.size = value;
        this.setPrice();
    }

    /**
     * Getter for Oled.
     *
     * @return boolean value for the state of oled for tv
     */
    public boolean getOled() {
        return this.oled;
    }

    /**
     * Oled Setter.
     *
     * @param value sets the Oled for Tv.
     */
    public void setOled(boolean value) {
        this.oled = value;
        this.setPrice();
    }

    /**
     * ToString method.
     *
     * @return A string with formatting for attributes of tv.
     */
    @Override
    public String toString() {
        if (this.getOled()) {
            return "" + this.getSize() + " OLED TV"; 
        } else {
            return "" + this.getSize() + " TV";
        }
        
    }

    /**
     * Method to return a generic name.
     */
    public String getName() {
        return "Television";
    }

    /**
     * Equals Override.
     *
     * <p>Overrides the Equals to determine whether an input is an original instance of
     the Television
     *
     * @param input instance of an object to see if it is an instance of Television
     * @return  boolean value determining if it is an original instance of Television
     */
    @Override
    public boolean equals(Object input) {
        if (input instanceof Television) {
            Television other = (Television) input;
            return this.getSize() == other.getSize()
                && this.getOled() == other.getOled();
        } else {
            return false;
        }
    }

    /**
     * Descriptors Method.
     *
     *<p>This method returns a linkedlist of strings describing the item.
     *
     * @return LinkedList of descriptions of item.
     */
    public LinkedList<String> descriptors() {
        LinkedList<String> descriptors = new LinkedList<>();
        descriptors.add(this.getSize() + "");
        if (this.getOled()) {
            descriptors.add("OLED");
        }
        return descriptors;
    }

    /**
     * Method to add options of item to LinkedList.
     *
     * @return Linked List of descriptions of object
     */
    public LinkedList<String> options() {
        LinkedList<String> options = new LinkedList<>();
        options.add(TvSize.THIRTYTWO + "");
        options.add(TvSize.FOURTYTHREE + "");
        options.add(TvSize.FIFTYFIVE + "");
        options.add(TvSize.SIXTYFIVE + "");
        options.add(TvSize.SEVENTYFIVE + "");
        options.add("OLED Available");
        return options;
    }

}