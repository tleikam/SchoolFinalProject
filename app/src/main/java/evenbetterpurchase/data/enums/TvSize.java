package evenbetterpurchase.data.enums;

/**
 * TvSize Enum class.
 *
 * <p>This is the Size Enum class providing available Sizes Tv's
 *
 * @author Travis Leikam
 * @version 0.1
 */
public enum TvSize {

    THIRTYTWO("32\"", 150.0),
    FOURTYTHREE("43\"", 300.0),
    FIFTYFIVE("55\"", 450.0),
    SIXTYFIVE("65\"", 600.0),
    SEVENTYFIVE("75\"", 750.0);

    private final String description;

    private final double value;

    /**
     * Contructor for TvSize.
     *
     * @param desciption string of size
     * @param value price of enum value
     */
    private TvSize(String description, double value) {
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
     * @return returns description of Size;
     */
    @Override
    public String toString() {
        return this.description;
    }
}