package evenbetterpurchase.data.hometheater;

import evenbetterpurchase.data.Item;
import java.util.LinkedList;

/**
 * Class for HomeAudio Objects.
 */
public class HomeAudio implements Item {

    private double price;
    private boolean sub;
    private boolean wireless;

    /**
     * Constructor for Home Audio.
     */
    public HomeAudio() {
        this.sub = false;
        this.wireless = false;
        this.setPrice();
    }

    /**
     * Formatter for URL.
     */
    public String getLink() {
        return "homeaudio";
    }
    
    /**
     * Price Getter.
     *
     * @return returns the value of the Audio.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Price Setter without discount.
     */
    public void setPrice() {
        double current = 299.99;
        if (this.getWireless()) {
            current += 100.0;
        }
        if (this.getSub()) {
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
     * Sub getter.
     *
     * @return sub included boolean
     */
    public boolean getSub() {
        return this.sub;
    }

    /**
     * Sub setter.
     *
     * @param value boolean value for sub value
     */
    public void setSub(boolean value) {
        this.sub = value;
        this.setPrice();
    }

    /**
     * Wireless getter.
     *
     * @return Wireless included boolean
     */
    public boolean getWireless() {
        return this.wireless;
    }

    /**
     * Wireless setter.
     *
     * @param value boolean value for Wireless value
     */
    public void setWireless(boolean value) {
        this.wireless = value;
        this.setPrice();
    }

    /**
     * ToString method.
     *
     * @return A string with formatting for attributes of home audio.
     */
    @Override
    public String toString() {
        String output = "";
        if (this.getWireless()) {
            output += "Wireless Home Audio System"; 
        } else {
            output += "Home Audio System";
        }
        if (this.getSub()) {
            output += " with Subwoofer";
        }
        return output;
    }

    /**
     * Method to return a generic name.
     */
    public String getName() {
        return "Home Audio System";
    }

    /**
     * Equals Override.
     *
     * <p>Overrides the Equals to determine whether an input is an original instance of
     the HomeAudio
     *
     * @param input instance of an object to see if it is an instance of HomeAudio
     * @return  boolean value determining if it is an original instance of HomeAudio
     */
    @Override
    public boolean equals(Object input) {
        if (input instanceof HomeAudio) {
            HomeAudio other = (HomeAudio) input;
            return this.getSub() == other.getSub()
                && this.getWireless() == other.getWireless();
        } else {
            return false;
        }
    }
    
    /**
     * Method to add description of item to LinkedList.
     *
     * @return Linked List of descriptions of object
     */
    public LinkedList<String> descriptors() {
        LinkedList<String> descriptors = new LinkedList<>();
        if (this.getWireless()) {
            descriptors.add("Wireless");
        }
        if (this.getSub()) {
            descriptors.add("With Sub");
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
        options.add("Wireless or Wired");
        options.add("With or Without Sub");
        return options;
    }

}