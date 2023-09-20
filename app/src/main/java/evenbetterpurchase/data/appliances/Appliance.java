package evenbetterpurchase.data.appliances;

import evenbetterpurchase.data.Item;
import evenbetterpurchase.data.enums.Color;
import java.util.LinkedList;

/**
 * Super class for appliances to be referenced to.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public abstract class Appliance implements Item {

    private Color color;

    /**
     * Constructor for an Appliance.
     */
    public Appliance() {
        // Do nothing for now
    }

    /**
     * Abstract getName method.
     */
    public abstract String getName();

    /**
     * Getter for color.
     *
     * @return Color of appliance
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Setter for the color.
     *
     * @param color Color of the appliance
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Abstract getPrice method.
     */
    public abstract double getPrice();

    public abstract void setPrice();
    
    /**
     * Descriptors getter.
     */
    public abstract LinkedList<String> descriptors();

}