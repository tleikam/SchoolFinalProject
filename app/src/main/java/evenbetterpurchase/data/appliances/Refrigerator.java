package evenbetterpurchase.data.appliances;

import evenbetterpurchase.data.enums.Color;
import java.util.LinkedList;

/**
 * Refrigerator Class.
 *
 *<p>This class creates an Object of Refrigerator, an
 appliance.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class Refrigerator extends Appliance {

    private boolean frenchDoors;
    private boolean lcdPanel;
    private boolean singleDrawerFreezer;
    private boolean doubleDrawerFreezer;
    private boolean iceMaker;
    private Color color;
    private double price;

    /**
     * Constructor for Refrigerator.
     */
    public Refrigerator() {
        this.frenchDoors = true;
        this.lcdPanel = true;
        this.singleDrawerFreezer = false;
        this.doubleDrawerFreezer = true;
        this.iceMaker = true;
        this.setColor(Color.STAINLESS_STEEL);
        this.setPrice();
    }

    /**
     * Formatter for URL.
     */
    public String getLink() {
        return "refrigerator";
    }

    /**
     * Price Getter.
     *
     * @return returns the value of the refrigerator.
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
        double current = 799.99;
        if (this.getFrenchDoors()) {
            current += 200.0;
        }
        if (this.getLcdPanel()) {
            current += 400.0;
        }
        if (this.getIceMaker()) {
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
     * @return returns color of refrigerator.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Color Setter.
     *
     * @param color sets the color for refrigerator.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * FrenchDoors Getter.
     *
     * @return returns boolean of FrenchDoors.
     */
    public boolean getFrenchDoors() {
        return this.frenchDoors;
    }

    /**
     * FrenchDoors Setter.
     *
     * @param value value for if refridge has FrenchDoors.
     */
    public void setFrenchDoors(boolean value) {
        this.frenchDoors = value;
        this.setPrice();
    }
    
    /**
     * LcdPanel Getter.
     *
     * @return returns boolean of LcdPanel.
     */
    public boolean getLcdPanel() {
        return this.lcdPanel;
    }

    /**
     * LcdPanel Setter.
     *
     * @param value value for if refridge has an LcdPanel.
     */
    public void setLcdPanel(boolean value) {
        this.lcdPanel = value;
        this.setPrice();
    }
    
    /**
     * SingleDrawerFreezer Getter.
     *
     * @return returns boolean of SingleDrawerFreezer.
     */
    public boolean getSingleDrawerFreezer() {
        return this.singleDrawerFreezer;
    }

    /**
     * SingleDrawerFreezer Setter.
     *
     * @param value value for if refridge has a SingleDrawerFreezer.
     */
    public void setSingleDrawerFreezer(boolean value) {
        this.singleDrawerFreezer = value;
        this.doubleDrawerFreezer = !(value);
        this.setPrice();
    }
    
    /**
     * DoubleDrawerFreezer Getter.
     *
     * @return returns boolean of DoubleDrawerFreezer.
     */
    public boolean getDoubleDrawerFreezer() {
        return this.doubleDrawerFreezer;
    }

    /**
     * DoubleDrawerFreezer Setter.
     *
     * @param value value for if refridge has a DoubleDrawerFreezer.
     */
    public void setDoubleDrawerFreezer(boolean value) {
        this.doubleDrawerFreezer = value;
        this.singleDrawerFreezer = !(value);
        this.setPrice();
    }

    /**
     * IceMaker Getter.
     *
     * @return returns boolean of IceMaker.
     */
    public boolean getIceMaker() {
        return this.iceMaker;
    }

    /**
     * IceMaker Setter.
     *
     * @param value value for if refridge has a IceMaker.
     */
    public void setIceMaker(boolean value) {
        this.iceMaker = value;
        this.setPrice();
    }

    /**
     * To String method for fridge.
     */
    @Override
    public String toString() {
        String output = "";
        output += this.getColor() + " Refrigerator";
        if (this.getFrenchDoors()) {
            output += " with French Doors";
        }
        return output;
    }

    /**
     * Method to return a generic name.
     */
    public String getName() {
        return "Refrigerator";
    }

    /**
     * Equals Override.
     *
     * <p>Overrides the Equals to determine whether an input is an original instance of
     the Refrigerator
     *
     * @param input instance of an object to see if it is an instance of Refrigerator
     * @return  boolean value determining if it is an original instance of Refrigerator
     */
    @Override
    public boolean equals(Object input) {
        if (input instanceof Refrigerator) {
            Refrigerator other = (Refrigerator) input;
            return this.getColor() == other.getColor()
                && this.iceMaker == other.iceMaker
                && this.frenchDoors == other.frenchDoors
                && this.lcdPanel == other.lcdPanel
                && this.singleDrawerFreezer == other.singleDrawerFreezer
                && this.doubleDrawerFreezer == other.doubleDrawerFreezer;
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
        if (this.frenchDoors) {
            descriptors.add("With French Doors");
        }
        if (this.lcdPanel) {
            descriptors.add("With LCD Display");
        }
        if (this.singleDrawerFreezer) {
            descriptors.add("Single Drawer Freezer");
        } else if (this.doubleDrawerFreezer) {
            descriptors.add("Double Drawer Freezer");
        }
        if (this.iceMaker) {
            descriptors.add("With Ice Maker");
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
        options.add("Ice Maker");
        options.add("LCD Display");
        options.add("French or Single Door");
        options.add("Single or Double Freezer Drawer");
        return options;
    }
}