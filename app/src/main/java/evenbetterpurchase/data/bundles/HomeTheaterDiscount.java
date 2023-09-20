package evenbetterpurchase.data.bundles;

import evenbetterpurchase.data.Item;
import evenbetterpurchase.data.hometheater.HomeAudio;
import evenbetterpurchase.data.hometheater.Television;
import java.util.LinkedList;

/**
 * Class to check for bundling of HomeTheater Items.
 */
public class HomeTheaterDiscount {

    /**
     * Class to perform discount calculation.
     *
     *<p>This class takes in an order, checks to see if
     the requirements for the discount is provided, and
     updates the price of the item if requirements are
     met.
     *
     * @param order Current order
     */
    public static void discount(LinkedList<Item> order) {
        boolean audio = false;
        boolean television = false;
        Television target = null;

        for (Item item : order) {
            if (item instanceof HomeAudio) {
                audio = true;
            }
            if (item instanceof Television) {
                television = true;
                target = (Television) item;
            }
        }

        if (target != null) {
            if (audio && television) {
                target.setPrice("discount");
            }
        }
    }
}