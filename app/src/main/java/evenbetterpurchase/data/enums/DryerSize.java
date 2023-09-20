package evenbetterpurchase.data.enums;

/**
 * DryerSize Enum class.
 *
 * <p>This is the DryerSize Enum class providing available size for Dryers
 *
 * @author Travis Leikam
 * @version 0.1
 */
public enum DryerSize {

    SIXPOINTSEVEN("6.7", 100.0),
    SEVENPOINTTHREE("7.3", 175.0),
    SEVENPOINTEIGHT("7.8", 250.0),
    NINEPOINTZERO("9.0", 325.0);

    private final String description;

    private final double value;

    /**
     * Contructor for DryerSize.
     *
     * <p>This method sets the String description equal to that of size
     *
     * @param desciption string of size
     * @param value price of enum value
     */
    private DryerSize(String description, double value) {
        this.description = description;
        this.value = value;
    }

    /**
     * Accessor method for values of DryerSize.
     *
     * @return returns cost of DryerSize
     */
    public double getValue() {
        return this.value;
    }

    /**
     * toString modifier.
     *
     * <p>This method overrides toString method to return the description
     *
     * @return returns description of DryerSize;
     */
    @Override
    public String toString() {
        return this.description;
    }
}