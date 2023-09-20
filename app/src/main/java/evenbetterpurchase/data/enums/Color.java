package evenbetterpurchase.data.enums;

/**
 * Color Enum class.
 *
 * <p>This is the Color Enum class providing available Colors
 *
 * @author Travis Leikam
 * @version 0.1
 */
public enum Color {

    STAINLESS_STEEL("Stainless Steel"),
    BLACK("Black"),
    WHITE("White"),
    BLUE("Blue");

    private final String description;

    /**
     * Contructor for size.
     *
     * @param value descriptor of enum value
     */
    private Color(String description) {
        this.description = description;
    }

    /**
     * toString modifier.
     *
     * <p>This method overrides toString method to return the description
     *
     * @return returns description of Color;
     */
    @Override
    public String toString() {
        return this.description;
    }
}