package evenbetterpurchase.data.enums;

/**
 * WasherSize Enum class.
 *
 * <p>This is the WasherSize Enum class providing available size for Washers
 *
 * @author Travis Leikam
 * @version 0.1
 */
public enum WasherSize {

    FOURPOINTFIVE("4.5", 500.0),
    FIVEPOINTZERO("5.0", 600.0),
    FIVEPOINTFIVE("5.5", 700.0),
    SIXPOINTZERO("6.0", 800.0);
    

    private final String description;

    private final double value;

    /**
     * Contructor for Size.
     *
     * <p>This method sets the String description equal to that of size
     *
     * @param desciption string of size
     * @param value price of enum value
     */
    private WasherSize(String description, double value) {
        this.description = description;
        this.value = value;
    }

    /**
     * Accessor method for values of WasherSize.
     *
     * @return returns cost of WasherSize
     */
    public double getValue() {
        return this.value;
    }

    /**
     * toString modifier.
     *
     * <p>This method overrides toString method to return the description
     *
     * @return returns description of WasherSize;
     */
    @Override
    public String toString() {
        return this.description;
    }
}